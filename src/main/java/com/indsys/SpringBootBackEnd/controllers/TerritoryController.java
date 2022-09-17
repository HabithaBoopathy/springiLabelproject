package com.indsys.SpringBootBackEnd.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.indsys.SpringBootBackEnd.models.Mexecutive;
import com.indsys.SpringBootBackEnd.models.Territory;
import com.indsys.SpringBootBackEnd.repositories.TerritoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/master/territory")
public class TerritoryController {
    @Autowired
    private TerritoryRepository territoryRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/all")
    public List<Territory> getAllTerritories() {
        return territoryRepository.findAll();
    }

    @PostMapping("/create")
    public Territory createTerritory(@RequestBody Territory territory){
        return territoryRepository.save(territory);
    }

    @PutMapping("/update")
    public Territory updateCompany(@RequestBody Territory territory){
        return territoryRepository.save(territory);
    }

    @GetMapping("/getByTerritoryId/{id}")
    public Territory getById(@PathVariable("id") String id){
        Optional<Territory> territory = territoryRepository.findById(id);
        return territory.orElse(null);
    }

    @GetMapping("/executiveId/{executiveId}")
    public List<Territory> getByExecutiveId(@PathVariable("executiveId") String executiveId){

        MatchOperation matchOperation = Aggregation.match(Criteria.where("executiveIds").in(executiveId));
        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
        AggregationResults<Territory> aggregationResults = mongoTemplate.aggregate(aggregation,
                Territory.class, Territory.class);

        return aggregationResults.getMappedResults();
    }

}