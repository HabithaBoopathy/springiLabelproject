package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.Munit;
import com.indsys.SpringBootBackEnd.repositories.MunitRepository;

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
public class MunitController {
    
    @Autowired
    MunitRepository munitRepository;

    @GetMapping("/unit")
	public List<Munit> getAllMcolors() {
		return munitRepository.findAll();
	}

	@GetMapping("/unit/unitname/{v}")
	public Munit getByUnitName(@PathVariable("v") String v){
		return munitRepository.getByUnitName(v);
	}

	@GetMapping("/unit/woven/{v}")
	public List<Munit> getByWoven(@PathVariable("v") String v){
		return munitRepository.getByWoven(v);
	}

	@GetMapping("/unit/printed/{v}")
	public List<Munit> getByPrinted(@PathVariable("v") String v){
		return munitRepository.getByPrinted(v);
	}

	@GetMapping("/unit/sticker/{v}")
	public List<Munit> getBySticker1(@PathVariable("v") String v){
		return munitRepository.getBySticker(v);
	}

	@GetMapping("/unit/tag/{v}")
	public List<Munit> getByTag1(@PathVariable("v") String v){
		return munitRepository.getByTag(v);
	}

	@GetMapping("/unit/{id}")
	public ResponseEntity<Munit> getMcolorById(@PathVariable(value = "id") String munitId)
			throws ResourceNotFoundException {
		Munit munit = munitRepository.findById(munitId)
				.orElseThrow(() -> new ResourceNotFoundException("Munit not found for this id :: " + munitId));
		return ResponseEntity.ok().body(munit);
	}

	@PostMapping("/unit")
	public Munit createMcolor(@Validated @RequestBody Munit munit) {
		return munitRepository.save(munit);
	}

	@PutMapping("/unit/{id}")
	public ResponseEntity<Munit> updateMcolor(@PathVariable(value = "id") String munitId,
			@Validated @RequestBody Munit munitDetails) throws ResourceNotFoundException {
				Munit munit = munitRepository.findById(munitId)
				.orElseThrow(() -> new ResourceNotFoundException("Munit not found for this id :: " + munitId));

		munit.setProductunit(munitDetails.getProductunit());
		munit.setPrinted(munitDetails.getPrinted());
		munit.setSticker(munitDetails.getSticker());
		munit.setTag(munitDetails.getTag());
		munit.setWoven(munitDetails.getWoven());
		final Munit updatedMcolor = munitRepository.save(munit);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/unit/{id}")
	public Map<String, Boolean> deleteMcolor(@PathVariable(value = "id") String munitId)
			throws ResourceNotFoundException {
				Munit munit = munitRepository.findById(munitId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + munitId));

		munitRepository.delete(munit);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
