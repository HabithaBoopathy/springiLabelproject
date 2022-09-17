package com.indsys.SpringBootBackEnd.repositories.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.Woven;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface WovenRepository extends MongoRepository<Woven, String> {
    
}
