package com.indsys.SpringBootBackEnd.v2.costingNew.repositories;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.StickerFlexoCosting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerFlexoCostingRepository extends MongoRepository<StickerFlexoCosting, String> {
}
