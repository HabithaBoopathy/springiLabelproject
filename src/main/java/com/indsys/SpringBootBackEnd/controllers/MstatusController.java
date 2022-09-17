package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.Mstatus;
import com.indsys.SpringBootBackEnd.repositories.MstatusRepository;

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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class MstatusController {
    
    @Autowired
    MstatusRepository mstatusRepository;

    @GetMapping("/status")
	public List<Mstatus> getAllMcolors() {
		return mstatusRepository.findAll();
	}

	@GetMapping("/status/statusname/{v}")
	public Mstatus getByStatusName(@PathVariable("v") String v){
		return mstatusRepository.getByStatusName(v);
	}

	@GetMapping("/status/woven/{v}")
	public List<Mstatus> getByWoven(@PathVariable("v") String v){
		return mstatusRepository.getByWoven(v);
	}

	@GetMapping("/status/printed/{v}")
	public List<Mstatus> getByPrinted(@PathVariable("v") String v){
		return mstatusRepository.getByPrinted(v);
	}

	@GetMapping("/status/tag/{v}")
	public List<Mstatus> getByTag(@PathVariable("v") String v){
		return mstatusRepository.getByTag(v);
	}

	@GetMapping("/status/{id}")
	public ResponseEntity<Mstatus> getMcolorById(@PathVariable(value = "id") String mstatusId)
			throws ResourceNotFoundException {
		Mstatus mstatus = mstatusRepository.findById(mstatusId)
				.orElseThrow(() -> new ResourceNotFoundException("Mstatus not found for this id :: " + mstatusId));
		return ResponseEntity.ok().body(mstatus);
	}

	@PostMapping("/status")
	public Mstatus createMcolor(@Validated @RequestBody Mstatus mstatus) {
		return mstatusRepository.save(mstatus);
	}

	@PutMapping("/status/{id}")
	public ResponseEntity<Mstatus> updateMcolor(@PathVariable(value = "id") String mstatusId,
			@Validated @RequestBody Mstatus mstatusDetails) throws ResourceNotFoundException {
				Mstatus mstatus = mstatusRepository.findById(mstatusId)
				.orElseThrow(() -> new ResourceNotFoundException("Mstatus not found for this id :: " + mstatusId));

		mstatus.setProductstatus(mstatusDetails.getProductstatus());
		mstatus.setPrinted(mstatusDetails.getPrinted());
		mstatus.setSticker(mstatusDetails.getSticker());
		mstatus.setTag(mstatusDetails.getTag());
		mstatus.setWoven(mstatusDetails.getWoven());
		final Mstatus updatedMcolor = mstatusRepository.save(mstatus);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/status/{id}")
	public Map<String, Boolean> deleteMcolor(@PathVariable(value = "id") String mstatusId)
			throws ResourceNotFoundException {
				Mstatus mstatus = mstatusRepository.findById(mstatusId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + mstatusId));

		mstatusRepository.delete(mstatus);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
