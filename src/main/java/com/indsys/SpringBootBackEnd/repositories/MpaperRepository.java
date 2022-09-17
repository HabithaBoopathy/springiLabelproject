package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.Mpaper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MpaperRepository extends MongoRepository<Mpaper, String> {
}
