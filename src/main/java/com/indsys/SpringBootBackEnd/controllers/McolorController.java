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
import com.indsys.SpringBootBackEnd.models.Mcolor;
import com.indsys.SpringBootBackEnd.repositories.McolorRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class McolorController {
	@Autowired
	private McolorRepository mcolorRepository;

	@GetMapping("/color")
	public List<Mcolor> getAllMcolors() {
		return mcolorRepository.findAll();
	}

	@GetMapping("/color/colorname/{v}")
	public Mcolor getByColorName(@PathVariable("v") String v){
		return mcolorRepository.getByColorName(v);
	}

	@GetMapping("/color/woven/{v}")
	public List<Mcolor> getByWoven(@PathVariable("v") String v){
		return mcolorRepository.getByWoven(v);
	}

	@GetMapping("/color/printed/{v}")
	public List<Mcolor> getByPrinted(@PathVariable("v") String v){
		return mcolorRepository.getByPrinted(v);
	}

	@GetMapping("/color/tag/{v}")
	public List<Mcolor> getByTag(@PathVariable("v") String v){
		return mcolorRepository.getByTag(v);
	}

	@GetMapping("/color/{id}")
	public ResponseEntity<Mcolor> getMcolorById(@PathVariable(value = "id") String mcolorId)
			throws ResourceNotFoundException {
		Mcolor mcolor = mcolorRepository.findById(mcolorId)
				.orElseThrow(() -> new ResourceNotFoundException("Mcolor not found for this id :: " + mcolorId));
		return ResponseEntity.ok().body(mcolor);
	}

	@PostMapping("/color")
	public Mcolor createMcolor(@Validated @RequestBody Mcolor mcolor) {
		return mcolorRepository.save(mcolor);
	}

	@PutMapping("/color/{id}")
	public ResponseEntity<Mcolor> updateMcolor(@PathVariable(value = "id") String mcolorId,
			@Validated @RequestBody Mcolor mcolorDetails) throws ResourceNotFoundException {
				Mcolor mcolor = mcolorRepository.findById(mcolorId)
				.orElseThrow(() -> new ResourceNotFoundException("Mcolor not found for this id :: " + mcolorId));
		mcolor.setColorname(mcolorDetails.getColorname());
		mcolor.setPrinted(mcolorDetails.getPrinted());
		mcolor.setSticker(mcolorDetails.getSticker());
		mcolor.setTag(mcolorDetails.getTag());
		mcolor.setWoven(mcolorDetails.getWoven());
		final Mcolor updatedMcolor = mcolorRepository.save(mcolor);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/color/{id}")
	public Map<String, Boolean> deleteMcolor(@PathVariable(value = "id") String mcolorId)
			throws ResourceNotFoundException {
				Mcolor mcolor = mcolorRepository.findById(mcolorId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + mcolorId));
		mcolorRepository.delete(mcolor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 