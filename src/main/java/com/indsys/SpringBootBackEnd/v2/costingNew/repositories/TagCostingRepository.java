package com.indsys.SpringBootBackEnd.v2.costingNew.repositories;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.TagCosting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagCostingRepository extends MongoRepository<TagCosting, String> {
}
