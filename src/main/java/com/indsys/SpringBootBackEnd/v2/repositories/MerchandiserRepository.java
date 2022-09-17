package com.indsys.SpringBootBackEnd.v2.repositories;

import com.indsys.SpringBootBackEnd.models.Mcolor;
import com.indsys.SpringBootBackEnd.v2.models.Merchandiser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchandiserRepository extends MongoRepository<Merchandiser, String> {

    @Query(value = "{'companyId':?0}")
    List<Merchandiser> getBycompanyId(String companyId);
}
