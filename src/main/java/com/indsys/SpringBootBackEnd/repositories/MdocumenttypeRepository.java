package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.Mdocumenttype;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface MdocumenttypeRepository extends MongoRepository <Mdocumenttype, String>{

    @Query(value = "{'doctype':?0}")
    Mdocumenttype getByDocumentType(String doctype);

    @Query(value = "{'sticker':?0}")
    List<Mdocumenttype> getBySticker(String sticker);

    @Query(value = "{'tag':?0}")
    List<Mdocumenttype> getByTag(String tag);
    
}
