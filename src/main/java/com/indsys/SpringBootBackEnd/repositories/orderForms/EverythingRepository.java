package com.indsys.SpringBootBackEnd.repositories.orderForms;

import java.util.Date;
import java.util.List;

import com.indsys.SpringBootBackEnd.models.orderForms.Everything;

import com.indsys.SpringBootBackEnd.models.report.Report;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.CommonDetailsCosting;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface EverythingRepository extends MongoRepository<Everything, String> {


    @Query(value = "{$and: [{'customerId': ?0}, {'status': {$gte: 4}}]}")
     List<Everything> getForCustomer(String id);



    //reporting
    @Aggregation(pipeline = {
            "{" +
                "$project: {" +
                    "date: {" +
                        "$dateFromString: {" +
                        "dateString: '$date', format: '%d-%m-%Y'" +
                        "}" +
                    "}, refNo: 1" +
                "}" +
            "}",
            "{" +
                "$match: {" +
                    "date: {" +
//                        "$gte: ISODate('2021-04-21T00:00:00Z')" +
                        "$gte: ?0" +
                    "}" +
                "}" +
            "}"
    })
    List<Everything> getReport(String startDate, String EndDate);

    @Query(value = "{'email':?0}")
    List <Everything> getByCustomerName(String email);

    @Query(value = "{'refNo':?0}")
    Everything getByEverythingReferenceNumber(String refNo);

    @Query(value = "{'executiveCode':?0}")
    List <Everything> getByExecutiveCode(String executiveCode);

    @Query(value = "{'refNum':?0}")
    List <Everything> getByExecutiveCheckNum(int refNum);

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $printRefNum }}}" })
	public int printMax();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $wovenRefNum }}}" })
	public int wovenMax();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $tagRefNum }}}" })
	public int tagMax();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $stickerRefNum }}}" })
	public int stickerMax();


    List <Everything> getBysampleName(String sampleName);

    List <Everything> getBytransactionStatus(String transactionStatus);

 
    // Admin Dashboard

    @Query(value = "{$and:[{'sampleName':?0},{'check':?1}]}")
    List <Everything> getAdminSampleNameCount(String sampleName, String check);

    @Query(value = "{$and:[{'transactionStatus':?0},{'check':?1}]}")
    List <Everything> getAdminTransactionCount(String transactionStatus, String check);

    @Query(value = "{$and:[{'transactionStatus':?0},{'sampleName':?1},{'check':?2}]}")
    List <Everything> getByAdminSampleNameAndTransactionCount(String transactionStatus, String sampleName, String check);


    // Customer Dashboard

    @Query(value = "{$and:[{'email':?0},{'sampleName':?1},{'check':?2}]}")
    List <Everything> getCustomerSampleCount(String email, String SampleName, String check);

    @Query(value = "{$and:[{'email':?0},{'transactionStatus':?1},{'check':?2}]}")
    List <Everything> getCustomerTransactionCount(String email, String transactionStatus, String check);

    @Query(value = "{$and:[{'email':?0},{'transactionStatus':?1},{'sampleName':?2},{'check':?3}]}")
    List <Everything> getCustomerSampleAndTransactionCount(String email, String transactionStatus, String SampleName, String check);


    // Executive Dashboard

    @Query(value = "{$and:[{'executiveCode':?0},{'sampleName':?1},{'check':?2}]}")
    List <Everything> getExecutiveSampleNameCount(String executiveCode, String SampleName, String check);

    @Query(value = "{$and:[{'executiveCode':?0},{'transactionStatus':?1},{'check':?2}]}")
    List <Everything> getExecutiveTransactionStatusCount(String executiveCode, String transactionStatus, String check);

    @Query(value = "{$and:[{'executiveCode':?0},{'transactionStatus':?1},{'sampleName':?2},{'check':?3}]}")
    List <Everything> getExecutiveSampleNameAndTransactionCount(String executiveCode, String transactionStatus, String sampleName, String check);



}
