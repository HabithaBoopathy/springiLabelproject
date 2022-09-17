package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.Login;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface LoginRepository extends MongoRepository<Login, String> {} 




