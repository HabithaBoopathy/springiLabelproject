package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.Logs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface LogsRepository extends MongoRepository<Logs, String> {
}




