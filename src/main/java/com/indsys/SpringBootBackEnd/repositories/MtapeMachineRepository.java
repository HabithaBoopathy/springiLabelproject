package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.MtapeMachine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtapeMachineRepository extends MongoRepository<MtapeMachine, String> {
}
