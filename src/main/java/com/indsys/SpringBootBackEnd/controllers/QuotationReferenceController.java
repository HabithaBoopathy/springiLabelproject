package com.indsys.SpringBootBackEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.QuotationReference;
import com.indsys.SpringBootBackEnd.repositories.QuotationReferenceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class QuotationReferenceController {
	@Autowired
	private QuotationReferenceRepository quotationReferenceRepository;

	@GetMapping("/quotationreference")
	public List<QuotationReference> getAllQuotationReferences() {
		return quotationReferenceRepository.findAll();
	}

	@GetMapping("/quotationreference/{id}")
	public ResponseEntity<QuotationReference> getQuotationReferenceById(@PathVariable(value = "id") String quotationReferenceId)
			throws ResourceNotFoundException {
				QuotationReference quotationReference = quotationReferenceRepository.findById(quotationReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Quotation Reference not found for this id :: " + quotationReferenceId));
		return ResponseEntity.ok().body(quotationReference);
	}

	@PostMapping("/quotationreference")
	public QuotationReference createQuotationReference(@Validated @RequestBody QuotationReference quotationReference) {
		return quotationReferenceRepository.save(quotationReference);
	}
}
 