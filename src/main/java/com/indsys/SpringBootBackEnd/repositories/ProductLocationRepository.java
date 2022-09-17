package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.ProductLocation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface ProductLocationRepository extends MongoRepository<ProductLocation, String> {
    
    @Query(value = "{'location':?0}")
    ProductLocation getByLocationName(String location);
}
