package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.MotherDetails;
import com.indsys.SpringBootBackEnd.repositories.MotherDetailsRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class MotherDetailsController {
	@Autowired
	private MotherDetailsRepository motherDetailsRepository;

	@GetMapping("/otherdetails")
	public List<MotherDetails> getAllMotherDetailss() {
		return motherDetailsRepository.findAll();
	}

	@GetMapping("/otherdetails/woven/{x}/{y}")
	public List<MotherDetails> getByWovenOtherDetailsWoven(@PathVariable("x") String x, @PathVariable("y") String y){
		return motherDetailsRepository.getByWovenOtherDetailsWoven(x, y);
	}

	@GetMapping("/otherdetails/printed/{x}/{y}")
	public List<MotherDetails> getByWovenOtherDetailsPrinted(@PathVariable("x") String x, @PathVariable("y") String y){
		return motherDetailsRepository.getByWovenOtherDetailsPrinted(x, y);
	}

	@GetMapping("/otherdetails/tag/{x}/{y}")
	public List<MotherDetails> getByWovenOtherDetailsTag(@PathVariable("x") String x, @PathVariable("y") String y){
		return motherDetailsRepository.getByWovenOtherDetailsTag(x, y);
	}

	@GetMapping("/otherdetails/{id}")
	public ResponseEntity<MotherDetails> getMotherDetailsById(@PathVariable(value = "id") String motherdetailsId)
			throws ResourceNotFoundException {
		MotherDetails motherdetails = motherDetailsRepository.findById(motherdetailsId)
				.orElseThrow(() -> new ResourceNotFoundException("MotherDetails not found for this id :: " + motherdetailsId));
		return ResponseEntity.ok().body(motherdetails);
	}

	@PostMapping("/otherdetails")
	public MotherDetails createMotherDetails(@Validated @RequestBody MotherDetails motherdetails) {
		return motherDetailsRepository.save(motherdetails);
	}

	@PutMapping("/otherdetails/{id}")
	public ResponseEntity<MotherDetails> updateMotherDetails(@PathVariable(value = "id") String motherdetailsId,
			@Validated @RequestBody MotherDetails motherdetailsDetails) throws ResourceNotFoundException {
				MotherDetails motherdetails = motherDetailsRepository.findById(motherdetailsId)
				.orElseThrow(() -> new ResourceNotFoundException("MotherDetails not found for this id :: " + motherdetailsId));

		motherdetails.setName(motherdetailsDetails.getName());
		motherdetails.setOtherdetails(motherdetailsDetails.getOtherdetails());
		motherdetails.setPrinted(motherdetailsDetails.getPrinted());
		motherdetails.setSticker(motherdetailsDetails.getSticker());
		motherdetails.setTag(motherdetailsDetails.getTag());
		motherdetails.setWoven(motherdetailsDetails.getWoven());
		final MotherDetails updatedMotherDetails = motherDetailsRepository.save(motherdetails);
		return ResponseEntity.ok(updatedMotherDetails);
	}


	@DeleteMapping("/otherdetails/{id}")
	public Map<String, Boolean> deleteMotherDetails(@PathVariable(value = "id") String motherdetailsId)
			throws ResourceNotFoundException {
				MotherDetails motherdetails = motherDetailsRepository.findById(motherdetailsId)
				.orElseThrow(() -> new ResourceNotFoundException("MotherDetails not found for this id :: " + motherdetailsId));

		motherDetailsRepository.delete(motherdetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
    
}