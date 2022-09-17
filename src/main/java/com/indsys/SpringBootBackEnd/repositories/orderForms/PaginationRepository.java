package com.indsys.SpringBootBackEnd.repositories.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.Everything;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaginationRepository extends MongoRepository<Everything, String> {
}
