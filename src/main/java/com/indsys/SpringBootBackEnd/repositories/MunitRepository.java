package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.Munit;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface MunitRepository extends MongoRepository <Munit, String> {
    
    @Query(value = "{'productunit':?0}")
    Munit getByUnitName(String productunit);

    @Query(value = "{'woven':?0}")
    List<Munit> getByWoven(String woven);

    @Query(value = "{'printed':?0}")
    List<Munit> getByPrinted(String printed);

    @Query(value = "{'sticker':?0}")
    List<Munit> getBySticker(String sticker);

    @Query(value = "{'tag':?0}")
    List<Munit> getByTag(String tag);
}
