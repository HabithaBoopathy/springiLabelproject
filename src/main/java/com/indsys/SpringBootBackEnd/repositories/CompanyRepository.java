package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.Company;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

}