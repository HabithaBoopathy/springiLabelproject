package com.indsys.SpringBootBackEnd.v2.repositories;

import com.indsys.SpringBootBackEnd.v2.models.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositoryV2 extends MongoRepository<Company, String> {
}
