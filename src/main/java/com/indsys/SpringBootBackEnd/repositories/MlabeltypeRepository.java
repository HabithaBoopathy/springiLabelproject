package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.Mlabeltype;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface MlabeltypeRepository extends MongoRepository <Mlabeltype, String>{

    @Query(value = "{'labelname':?0}")
    Mlabeltype getByLabelName(String labelname);

    @Query(value = "{'woven':?0}")
    List<Mlabeltype> getByWoven(String woven);

    @Query(value = "{'printed':?0}")
    List<Mlabeltype> getByPrinted(String printed);
    
}
