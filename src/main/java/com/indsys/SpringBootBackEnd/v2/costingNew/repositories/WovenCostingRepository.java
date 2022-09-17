package com.indsys.SpringBootBackEnd.v2.costingNew.repositories;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.WovenCosting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WovenCostingRepository extends MongoRepository<WovenCosting, String> {
}
