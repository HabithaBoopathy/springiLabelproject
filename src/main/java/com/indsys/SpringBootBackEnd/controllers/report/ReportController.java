package com.indsys.SpringBootBackEnd.controllers.report;

import com.indsys.SpringBootBackEnd.models.Employee;
import com.indsys.SpringBootBackEnd.models.orderForms.Everything;
import com.indsys.SpringBootBackEnd.models.report.Report;
import com.indsys.SpringBootBackEnd.models.report.ReportOutput;
import com.indsys.SpringBootBackEnd.models.report.TerritoryFilterOutput;
import com.indsys.SpringBootBackEnd.repositories.orderForms.EverythingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value="/api/report")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    EverythingRepository everythingRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping()
    public List<ReportOutput> getReport(@RequestBody Report report){

        Date startDate = new Date(), endDate = new Date();

        //Java parsing start and end date from dd-MM-yyyy to ISO format
        //so that it can be used in the query, as we are converting all other dates to ISO format in mongo
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            startDate = formatter.parse(report.getStartDate());
            endDate = formatter.parse(report.getEndDate());

//            System.out.println("Start Date is: "+startDate);
//            System.out.println("End Date is: "+endDate);
        } catch (ParseException e) {e.printStackTrace();}

        /*
            Specified territory filters and everything object has no direct relation
            1. territory is mapped to the customer in the customer object
            2. customer is mapped to everything using the email property of the customer (ID hasn't been used)

            So, 1st find all the corresponding customer mail ids mapped to the given territory filters
            then use those mail ids as a filter in the everything object
        */

        /* 1. Dedicated aggregation for territory filter on the employee collection (customer collection) */
        /*AggregationResults<TerritoryFilterOutput> aggregationResults1 = null;
        String[] emailArray = null;

        if(report.getTerritory().length > 0){

            //match the given territories
            MatchOperation matchStage = Aggregation.match(Criteria.where("territory").in(Arrays.asList(report.getTerritory())));

            //project only the necessary emailId field
            ProjectionOperation projectionStage = Aggregation.project("emailId");

            Aggregation aggregation = Aggregation.newAggregation(matchStage, projectionStage);

            aggregationResults1 = mongoTemplate.aggregate(aggregation,
                    Employee.class,
                    TerritoryFilterOutput.class);

            //convert the aggregation results to a string array containing the corresponding email ids
            emailArray = aggregationResults1.getMappedResults().stream().map(TerritoryFilterOutput::getEmailId).toArray(String[]::new);
        }*/

        /* 2. Dedicated aggregation for all filters on the everything collection */

        /*
            array to store all the individual aggregation objects dynamically
            (since some operations may result in null) to perform final aggregation
        */
        List<AggregationOperation> aggregationOperations = new ArrayList<AggregationOperation>();

        //converting existing date strings to ISO Format
        ProjectionOperation projectionStage1 = Aggregation.project(
                "date","email","territoryId","refNo","sampleName","sampName","name","transactionStatus","check","expectedDate")
                .and(DateOperators.DateFromString.fromStringOf("date").withFormat("%d-%m-%Y")).as("date");
        aggregationOperations.add(projectionStage1);

        //match operation - 5 stages
        //date - greater than or equal to start date && less than or equal to end date
        //check - specified territory's mapped emails
        //check - active - to ignore disabled orders
        //trimType filter
        //transactionStatus filter

        //initializing criteriaMatch with date and check criteria at first, then after validation
        //trimType and transactionStatus criteria will be inserted

        //Matching only the documents between the specified range
        MatchOperation matchStage1 = Aggregation.match(
                Criteria.where("date").gte(startDate).lte(endDate)
        );
        aggregationOperations.add(matchStage1);

        //matching only the orders with active status (ie., un archived)
        MatchOperation matchStage2 = Aggregation.match(
                Criteria.where("check").is("active")
        );
        aggregationOperations.add(matchStage2);

//        Criteria criteriaMatch = new Criteria().andOperator(Criteria.where("date").gte(startDate).lte(endDate),
//                Criteria.where("check").is("active"));

        if(report.getTerritory().length > 0){
            //Match only the documents mapped under specified territories
            /*MatchOperation matchStage3 = Aggregation.match(
                    Criteria.where("email").in(Arrays.asList(emailArray))
            );*/
            MatchOperation matchStage3 = Aggregation.match(
                    Criteria.where("territoryId").in(Arrays.asList(report.getTerritory()))
            );
            aggregationOperations.add(matchStage3);
//            criteriaMatch.and("email").in(Arrays.asList(emailArray));
        }

        if(report.getTrimType().length > 0){
            //Match only the documents mapped under specified trimTypes
            MatchOperation matchStage4 = Aggregation.match(
                    Criteria.where("sampleName").in(Arrays.asList(report.getTrimType()))
            );
            aggregationOperations.add(matchStage4);
//            criteriaMatch.and("sampleName").in(Arrays.asList(report.getTrimType()));
        }

        if(report.getTransactionStatus().length > 0){
            //Match only the documents mapped under specified transaction status
            MatchOperation matchStage5 = Aggregation.match(
                    Criteria.where("transactionStatus").in(Arrays.asList(report.getTransactionStatus()))
            );
            aggregationOperations.add(matchStage5);
//            criteriaMatch.and("transactionStatus").in(Arrays.asList(report.getTransactionStatus()));
        }

//        MatchOperation matchStage = Aggregation.match(criteriaMatch);

        //if val is 1 - sort ascending else descending
        Sort.Direction sortDirection = (report.getSort() == 1)?Sort.Direction.ASC:Sort.Direction.DESC;
        SortOperation sortStage = Aggregation.sort(Sort.by(sortDirection, "date"));
        aggregationOperations.add(sortStage);

        //after sorting converting date and expected to dd-mm-yyyy format
        //also excluding id and check fields
        ProjectionOperation projectionStage2 = Aggregation.project(
                "date","refNo","sampleName","sampName","name","transactionStatus","expectedDate")
                .andExclude("_id")
                .and(
                        DateOperators.DateToString.dateOf("date").toString("%d-%m-%Y IST")
                ).as("date")
                .and(
                        DateOperators.DateToString.dateOf(
                                DateOperators.DateFromString.fromStringOf("expectedDate").withFormat("%Y-%m-%d")
                        ).toString("%d-%m-%Y IST")
                ).as("expectedDate");
        aggregationOperations.add(projectionStage2);

        Aggregation aggregation = Aggregation.newAggregation(aggregationOperations);

        AggregationResults<ReportOutput> aggregationResults = mongoTemplate.aggregate(aggregation,
                Everything.class,
                ReportOutput.class);

        return aggregationResults.getMappedResults();
    }
}
