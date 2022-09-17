package com.indsys.SpringBootBackEnd.repositories.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.CostingSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CostingSheetRepository extends MongoRepository<CostingSheet, String> {

    @Query(value = "{'orderId':?0}")
    CostingSheet findByOrderId(String orderId);
}
