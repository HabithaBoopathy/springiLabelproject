package com.indsys.SpringBootBackEnd.repositories.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.Sticker;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface StickerRepository extends MongoRepository<Sticker, String> {
    
}
