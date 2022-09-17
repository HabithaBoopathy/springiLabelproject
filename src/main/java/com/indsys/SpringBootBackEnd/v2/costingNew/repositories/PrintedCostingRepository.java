package com.indsys.SpringBootBackEnd.v2.costingNew.repositories;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.PrintedCosting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrintedCostingRepository extends MongoRepository<PrintedCosting, String> {
}
