package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.Mcolor;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface McolorRepository extends MongoRepository <Mcolor, String> {
    
    @Query(value = "{'colorname':?0}")
    Mcolor getByColorName(String colorname);

    @Query(value = "{'woven':?0}")
    List<Mcolor> getByWoven(String woven);

    @Query(value = "{'printed':?0}")
    List<Mcolor> getByPrinted(String printed);

    @Query(value = "{'tag':?0}")
    List<Mcolor> getByTag(String tag);
    
}
