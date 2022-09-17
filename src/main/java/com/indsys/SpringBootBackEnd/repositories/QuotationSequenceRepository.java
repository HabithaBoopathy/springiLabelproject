package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.QuotationSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotationSequenceRepository extends MongoRepository<QuotationSequence, String> {


}
