package com.indsys.SpringBootBackEnd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indsys.SpringBootBackEnd.models.QuotationForm;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@Repository
@ComponentScan({ "com.indsys.SpringBootBackEnd" })
@EntityScan("com.indsys.SpringBootBackEnd")
public interface QuotationFormRepository extends MongoRepository<QuotationForm, String> {
}




