package com.indsys.SpringBootBackEnd.repositories;

import java.util.List;

import com.indsys.SpringBootBackEnd.models.UserProfile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Repository
@ComponentScan({ "com.indsys.SpringBootBackEnd" })
@EntityScan("com.indsys.SpringBootBackEnd")
public interface UserRepository extends MongoRepository<UserProfile, String> {

    @Query(value="{'loginId': ?0}")
    UserProfile getByloginId(String loginId);
    
    @Query(value = "{$and:[{'loginId': ?0},{'password': ?1}]}")
    UserProfile getByLoginIDandPassword(String loginId, String password);

    @Query(value = "{'accessRights':?0}")
    List <UserProfile> getByAccessRightsAndTrimTypes(String accessRights);

    @Query(value = "{$and:[{'accessRights': ?0},{'superUser': ?1}]}")
    List <UserProfile> getByAccessRightsAndSuperUser(String accessRights, Boolean superUser);
}




