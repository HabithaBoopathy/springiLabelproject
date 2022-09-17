package com.indsys.SpringBootBackEnd.service.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.Everything;
import com.indsys.SpringBootBackEnd.models.orderForms.PaginationInput;
import com.indsys.SpringBootBackEnd.repositories.orderForms.PaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PaginationService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    PaginationRepository paginationRepository;

    public Page<Everything> getOrders(PaginationInput paginationInput){

        //creating pageable - try to add sort in here itself as 3rd parameter
        Pageable pageable = PageRequest.of(
                paginationInput.getPage(),
                paginationInput.getSize() != 0 ? paginationInput.getSize() : 10
        );

        //instantiating the Query object with pageable object, created in the controller
        Query query = new Query().with(pageable);

        //userBased Criteria
        Criteria totalCriteria = new Criteria();

        //if the executive code is not an empty string
        if(!(paginationInput.getExecutiveCode().equals("") || paginationInput.getExecutiveCode() == null)){
            totalCriteria = Criteria.where("executiveCode").is(paginationInput.getExecutiveCode());
        }
        //else if the customer email is not an empty string
        else if(!(paginationInput.getCustomerEmail().equals("") || paginationInput.getExecutiveCode() == null)){
            totalCriteria = Criteria.where("email").is(paginationInput.getCustomerEmail());
        }

        //else if the user is TManager
        else if(paginationInput.getTerritoryId().length>0){
            totalCriteria = Criteria.where("territoryId").in(Arrays.asList(paginationInput.getTerritoryId()));
        }
        //else the user is either admin/sample head

        totalCriteria.and("check").is(paginationInput.getStatus());

        if(paginationInput.getTrimType().length > 0){
            totalCriteria.and("sampleName").in(Arrays.asList(paginationInput.getTrimType()));
        }

        if(paginationInput.getTransactionStatus().length > 0){
            totalCriteria.and("transactionStatus").in(Arrays.asList(paginationInput.getTransactionStatus()));
        }



        //global search criteria
        if(
                (!(paginationInput.getGlobalSearchInput().getField().equals("")
                || paginationInput.getGlobalSearchInput().getField() == null))
                        &&
                (!(paginationInput.getGlobalSearchInput().getValue().equals("")
                || paginationInput.getGlobalSearchInput().getValue() == null))
        ){
            totalCriteria.and(paginationInput.getGlobalSearchInput().getField())
                    .regex(paginationInput.getGlobalSearchInput().getValue(), "i");
        }

        query.addCriteria(totalCriteria);

        if(paginationInput.getSort().equals("desc")){
            query.with(Sort.by(Sort.Direction.DESC, "id"));
        }

        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Everything.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), Everything.class)
        );
    }
}
