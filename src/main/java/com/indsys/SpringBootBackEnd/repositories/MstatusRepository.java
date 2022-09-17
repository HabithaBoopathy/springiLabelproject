package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.Mstatus;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface MstatusRepository extends MongoRepository<Mstatus, String> {
    
    @Query(value = "{'productstatus':?0}")
    Mstatus getByStatusName(String productstatus);

    @Query(value = "{'woven':?0}")
    List<Mstatus> getByWoven(String woven);

    @Query(value = "{'printed':?0}")
    List<Mstatus> getByPrinted(String printed);

    @Query(value = "{'tag':?0}")
    List<Mstatus> getByTag(String tag);
}
