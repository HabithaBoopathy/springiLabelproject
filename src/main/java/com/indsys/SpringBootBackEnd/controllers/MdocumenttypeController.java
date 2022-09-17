package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.Mdocumenttype;
import com.indsys.SpringBootBackEnd.repositories.MdocumenttypeRepository;

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
public class MdocumenttypeController {
    
    @Autowired
    MdocumenttypeRepository mdocumenttypeRepository;

    @GetMapping("/documenttype")
	public List<Mdocumenttype> getAllMcolors() {
		return mdocumenttypeRepository.findAll();
	}

	@GetMapping("/documenttype/type/{v}")
	public Mdocumenttype getByDocumentType(@PathVariable("v") String v){
		return mdocumenttypeRepository.getByDocumentType(v);
	}

	@GetMapping("/documenttype/sticker/{v}")
	public List<Mdocumenttype> getBySticker(@PathVariable("v") String v){
		return mdocumenttypeRepository.getBySticker(v);
	}

	@GetMapping("/documenttype/tag/{v}")
	public List<Mdocumenttype> getByTag(@PathVariable("v") String v){
		return mdocumenttypeRepository.getByTag(v);
	}

	@GetMapping("/documenttype/{id}")
	public ResponseEntity<Mdocumenttype> getMcolorById(@PathVariable(value = "id") String mdocumenttypeId)
			throws ResourceNotFoundException {
		Mdocumenttype mdocumenttype = mdocumenttypeRepository.findById(mdocumenttypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Mdocumenttype not found for this id :: " + mdocumenttypeId));
		return ResponseEntity.ok().body(mdocumenttype);
	}

	@PostMapping("/documenttype")
	public Mdocumenttype createMcolor(@Validated @RequestBody Mdocumenttype mdocumenttype) {
		return mdocumenttypeRepository.save(mdocumenttype);
	}

	@PutMapping("/documenttype/{id}")
	public ResponseEntity<Mdocumenttype> updateMcolor(@PathVariable(value = "id") String mdocumenttypeId,
			@Validated @RequestBody Mdocumenttype mdocumenttypeDetails) throws ResourceNotFoundException {
				Mdocumenttype mdocumenttype = mdocumenttypeRepository.findById(mdocumenttypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Mdocumenttype not found for this id :: " + mdocumenttypeId));

		mdocumenttype.setDoctype(mdocumenttypeDetails.getDoctype());
		mdocumenttype.setPrinted(mdocumenttypeDetails.getPrinted());
		mdocumenttype.setSticker(mdocumenttypeDetails.getSticker());
		mdocumenttype.setTag(mdocumenttypeDetails.getTag());
		mdocumenttype.setWoven(mdocumenttypeDetails.getWoven());
		final Mdocumenttype updatedMcolor = mdocumenttypeRepository.save(mdocumenttype);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/documenttype/{id}")
	public Map<String, Boolean> deleteMcolor(@PathVariable(value = "id") String mdocumenttypeId)
			throws ResourceNotFoundException {
				Mdocumenttype mdocumenttype = mdocumenttypeRepository.findById(mdocumenttypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + mdocumenttypeId));

		mdocumenttypeRepository.delete(mdocumenttype);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
