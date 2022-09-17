package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.Mexecutive;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface MexecutiveRepository extends MongoRepository <Mexecutive, String> {

    @Query(value = "{'emailId':?0}")
    Mexecutive getByExecutiveEmail(String emailId);

    @Query(value = "{'name':?0}")
    Mexecutive getByExecutiveName(String name);

    @Query(value = "{'code':?0}")
    Mexecutive getByExecutiveCode(String code);
    
}
