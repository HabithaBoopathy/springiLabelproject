package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.Mlabeltype;
import com.indsys.SpringBootBackEnd.repositories.MlabeltypeRepository;

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
public class MlabeltypeController {
    
    @Autowired
    MlabeltypeRepository mlabeltypeRepository;

    @GetMapping("/labeltype")
	public List<Mlabeltype> getAllMcolors() {
		return mlabeltypeRepository.findAll();
	}

	@GetMapping("/labeltype/type/{v}")
	public Mlabeltype getByLabelName(@PathVariable("v") String v){
		return mlabeltypeRepository.getByLabelName(v);
	}

	@GetMapping("/labeltype/woven/{v}")
	public List<Mlabeltype> getByWoven(@PathVariable("v") String v){
		return mlabeltypeRepository.getByWoven(v);
	}

	@GetMapping("/labeltype/printed/{v}")
	public List<Mlabeltype> getByPrinted(@PathVariable("v") String v){
		return mlabeltypeRepository.getByPrinted(v);
	}

	@GetMapping("/labeltype/{id}")
	public ResponseEntity<Mlabeltype> getMcolorById(@PathVariable(value = "id") String mlabeltypeId)
			throws ResourceNotFoundException {
		Mlabeltype mlabeltype = mlabeltypeRepository.findById(mlabeltypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Mlabeltype not found for this id :: " + mlabeltypeId));
		return ResponseEntity.ok().body(mlabeltype);
	}

	@PostMapping("/labeltype")
	public Mlabeltype createMcolor(@Validated @RequestBody Mlabeltype mlabeltype) {
		return mlabeltypeRepository.save(mlabeltype);
	}

	@PutMapping("/labeltype/{id}")
	public ResponseEntity<Mlabeltype> updateMcolor(@PathVariable(value = "id") String mlabeltypeId,
			@Validated @RequestBody Mlabeltype mlabeltypeDetails) throws ResourceNotFoundException {
				Mlabeltype mlabeltype = mlabeltypeRepository.findById(mlabeltypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Mlabeltype not found for this id :: " + mlabeltypeId));

		mlabeltype.setLabelname(mlabeltypeDetails.getLabelname());
		mlabeltype.setPrinted(mlabeltypeDetails.getPrinted());
		mlabeltype.setSticker(mlabeltypeDetails.getSticker());
		mlabeltype.setTag(mlabeltypeDetails.getTag());
		mlabeltype.setWoven(mlabeltypeDetails.getWoven());
		final Mlabeltype updatedMcolor = mlabeltypeRepository.save(mlabeltype);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/labeltype/{id}")
	public Map<String, Boolean> deleteMcolor(@PathVariable(value = "id") String mlabeltypeId)
			throws ResourceNotFoundException {
				Mlabeltype mlabeltype = mlabeltypeRepository.findById(mlabeltypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + mlabeltypeId));

		mlabeltypeRepository.delete(mlabeltype);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
