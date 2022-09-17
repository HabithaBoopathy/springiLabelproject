package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.CustomerReference;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface CustomerReferenceRepository extends MongoRepository<CustomerReference, String> {
    
}
