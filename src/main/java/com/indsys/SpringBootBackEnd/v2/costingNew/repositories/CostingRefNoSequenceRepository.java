package com.indsys.SpringBootBackEnd.v2.costingNew.repositories;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.CostingRefNoSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostingRefNoSequenceRepository extends MongoRepository<CostingRefNoSequence, String> {
}
