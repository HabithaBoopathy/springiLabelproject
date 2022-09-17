package com.indsys.SpringBootBackEnd.repositories;

import com.indsys.SpringBootBackEnd.models.ProductReference;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan({"com.indsys.SpringBootBackEnd"})
@EntityScan("com.indsys.SpringBootBackEnd")
public interface ProductReferenceRepository extends MongoRepository<ProductReference, String> {

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $printNum }}}" })
	public int printMax();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $wovenNum }}}" })
	public int wovenMax();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $tagNum }}}" })
	public int tagMax();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $stickerNum }}}" })
	public int stickerMax();
    
}
