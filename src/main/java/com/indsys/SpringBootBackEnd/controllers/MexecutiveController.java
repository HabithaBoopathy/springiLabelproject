package com.indsys.SpringBootBackEnd.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.Mexecutive;
import com.indsys.SpringBootBackEnd.models.Territory;
import com.indsys.SpringBootBackEnd.repositories.MexecutiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class MexecutiveController {
    @Autowired
    private MexecutiveRepository mexecutiveRepository;

    @Autowired
	MongoTemplate mongoTemplate;

    @GetMapping("/executive")
	public List<Mexecutive> getAllMexecutives() {
		return mexecutiveRepository.findAll();
	}

	@GetMapping("/executive/executiveemail/{v}")
	public Mexecutive getByExecutiveEmail(@PathVariable("v") String v){
		return mexecutiveRepository.getByExecutiveEmail(v);
	}

	@GetMapping("/executive/executivename/{v}")
	public Mexecutive getByExecutiveNameCheck(@PathVariable("v") String v){
		return mexecutiveRepository.getByExecutiveName(v);
	}

	@GetMapping("/executive/executivecode/{v}")
	public Mexecutive getByExecutiveCode(@PathVariable("v") String v){
		return mexecutiveRepository.getByExecutiveCode(v);
	}

	@GetMapping("/executive/{id}")
	public ResponseEntity<Mexecutive> getMexecutiveById(@PathVariable(value = "id") String mexecutiveId)
			throws ResourceNotFoundException {
		Mexecutive mexecutive = mexecutiveRepository.findById(mexecutiveId)
				.orElseThrow(() -> new ResourceNotFoundException("Mexecutive not found for this id :: " + mexecutiveId));
		return ResponseEntity.ok().body(mexecutive);
	}

	@PostMapping("/executive")
	public Mexecutive createMexecutive(@Validated @RequestBody Mexecutive mexecutive) {
		return mexecutiveRepository.save(mexecutive);
	}

	@PutMapping("/executive/update/{id}")
	public Mexecutive uMexecutive(@PathVariable(value = "id")String mexecutiveId, @RequestBody Mexecutive mexecutive){
		return mexecutiveRepository.save(mexecutive);

	}

	@PutMapping("/executive/{id}")
	public ResponseEntity<Mexecutive> updateMexecutive(@PathVariable(value = "id") String mexecutiveId,
			@Validated @RequestBody Mexecutive mexecutiveDetails) throws ResourceNotFoundException {
				Mexecutive mexecutive = mexecutiveRepository.findById(mexecutiveId)
				.orElseThrow(() -> new ResourceNotFoundException("Mexecutive not found for this id :: " + mexecutiveId));

		mexecutive.setName(mexecutiveDetails.getName());
		mexecutive.setEmailId(mexecutiveDetails.getEmailId());
		mexecutive.setCode(mexecutiveDetails.getCode());
		mexecutive.setPhoneNumber(mexecutiveDetails.getPhoneNumber());
		mexecutive.setTerritories(mexecutiveDetails.getTerritories());
		final Mexecutive updatedMexecutive = mexecutiveRepository.save(mexecutive);
		return ResponseEntity.ok(updatedMexecutive);
	}

	@DeleteMapping("/executive/{id}")
	public Map<String, Boolean> deleteMexecutive(@PathVariable(value = "id") String mexecutiveId)
			throws ResourceNotFoundException {
				Mexecutive mexecutive = mexecutiveRepository.findById(mexecutiveId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + mexecutiveId));

		mexecutiveRepository.delete(mexecutive);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/executive/territoryId/{territoryId}")
	public List<Mexecutive> getExecutivesByTerritoryId(@PathVariable("territoryId") String territoryId){

    	//use the territoryId to find the mapped executiveIds
		MatchOperation matchOperation = Aggregation.match(Criteria.where("_id").is(territoryId));

		Aggregation aggregation = Aggregation.newAggregation(matchOperation);

		AggregationResults<Territory> aggregationResults = mongoTemplate.aggregate(aggregation,
				Territory.class, Territory.class);

		if(aggregationResults.getMappedResults().size()<1){
			return null;
		}
		//Now use the executiveIds to fetch exec name and code
		String[] executiveIds = aggregationResults.getMappedResults().get(0).getExecutiveIds();

		ProjectionOperation projectionOperation = Aggregation.project("name", "code");

		MatchOperation matchOperation2 = Aggregation.match(Criteria.where("_id").in(Arrays.asList(executiveIds)));

		Aggregation aggregation2 = Aggregation.newAggregation(projectionOperation, matchOperation2);

		AggregationResults<Mexecutive> aggregationResults2 = mongoTemplate.aggregate(aggregation2, Mexecutive.class,
				Mexecutive.class);

		return aggregationResults2.getMappedResults();
	}
}
