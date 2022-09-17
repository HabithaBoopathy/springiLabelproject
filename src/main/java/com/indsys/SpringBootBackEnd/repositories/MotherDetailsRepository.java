package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.MotherDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface MotherDetailsRepository extends MongoRepository<MotherDetails, String> {

    @Query(value = "{$and:[{'otherdetails': ?0},{'woven': ?1}]}")
    List<MotherDetails> getByWovenOtherDetailsWoven(String otherdetails, String woven);

    @Query(value = "{$and:[{'otherdetails': ?0},{'printed': ?1}]}")
    List<MotherDetails> getByWovenOtherDetailsPrinted(String otherdetails, String printed);

    @Query(value = "{$and:[{'otherdetails': ?0},{'tag': ?1}]}")
    List<MotherDetails> getByWovenOtherDetailsTag(String otherdetails, String tag);
} 




