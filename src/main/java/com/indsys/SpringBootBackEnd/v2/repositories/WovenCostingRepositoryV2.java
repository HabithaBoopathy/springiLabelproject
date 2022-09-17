package com.indsys.SpringBootBackEnd.v2.repositories;

import com.indsys.SpringBootBackEnd.v2.models.WovenCostingV2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WovenCostingRepositoryV2 extends MongoRepository<WovenCostingV2, String> {
    @Query(value = "{'orderId':?0}")
    WovenCostingV2 getByOrderId(String orderId);
}
