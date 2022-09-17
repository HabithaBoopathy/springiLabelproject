package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.indsys.SpringBootBackEnd.models.QuotationSequence;
import com.indsys.SpringBootBackEnd.repositories.QuotationSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
import com.indsys.SpringBootBackEnd.models.QuotationForm;
import com.indsys.SpringBootBackEnd.repositories.QuotationFormRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class QuotationFormController {

	@Autowired
	private QuotationFormRepository quotationFormRepository;

	@Autowired
	private QuotationSequenceRepository quotationSequenceRepository;

	QuotationForm quotationFormToReturn;

	public void insertQuotationForm(QuotationForm quotationForm, int seqNo,
									QuotationSequence quotationSequence){
		Boolean flag = false;

		//concatenate the last seqNo
		quotationForm.setQuotationReferenceNumber("DQ" + quotationForm.getTrimType() + seqNo);

		try {
			//inserted successfully
			quotationFormRepository.save(quotationForm);
			flag = true;
			quotationFormToReturn = quotationForm;
		}catch (DuplicateKeyException e){
			//duplicate error - so flag defaults to false
			System.out.println("Error occurred " + e.getMessage());
		}

		//if successfully inserted, then incrementing seqNo
		if(flag){
			quotationSequence.setSequenceNo(seqNo+1);
			quotationSequenceRepository.save(quotationSequence);
		}
		//else - recursion
		else{
			insertQuotationForm(quotationForm, seqNo+1, quotationSequence);
		}
	}

	@PostMapping("/quotations")
	public QuotationForm createQuotationForm(@RequestBody QuotationForm quotationForm) {

		if (quotationForm.getId() == null) {
			//id is null - so insert the form
			//find the corresponding sequence object
			Optional<QuotationSequence> quotationSequence = quotationSequenceRepository.findById(quotationForm.getTrimType());

			if(quotationSequence.isPresent()) {

				//find the last sequence no
				int seqNo =  quotationSequence.get().getSequenceNo();

				//set seqNo to the current obj and insert it
				insertQuotationForm(quotationForm, seqNo, quotationSequence.get());

				//if it doesn't work it means code haven't waited for recursion to get complete

				return quotationFormToReturn;
			}
			return null;
		} else {
			//id is not null - so update the existing form
			return quotationFormRepository.save(quotationForm);
		}

	}

	@GetMapping("/quotations")
	public List<QuotationForm> getAllQuotationForms() {
		return quotationFormRepository.findAll();
	}

	@GetMapping("/quotations/{id}")
	public ResponseEntity<QuotationForm> getQuotationFormById(@PathVariable(value = "id") String quotationId)
			throws ResourceNotFoundException {
		QuotationForm quotation = quotationFormRepository.findById(quotationId)
				.orElseThrow(() -> new ResourceNotFoundException("QuotationForm not found for this id :: " + quotationId));
		return ResponseEntity.ok().body(quotation);
	}



	@PutMapping("/quotations/{id}")
	public ResponseEntity<QuotationForm> updateQuotationForm(@PathVariable(value = "id") String quotationId,
															 @Validated @RequestBody QuotationForm quotationDetails) throws ResourceNotFoundException {
		QuotationForm quotation = quotationFormRepository.findById(quotationId)
				.orElseThrow(() -> new ResourceNotFoundException("QuotationForm not found for this id :: " + quotationId));

		// quotation.setUsername(quotationDetails.getUsername());

		final QuotationForm updatedQuotationForm = quotationFormRepository.save(quotation);
		return ResponseEntity.ok(updatedQuotationForm);
	}

	@DeleteMapping("/quotations/{id}")
	public Map<String, Boolean> deleteQuotationForm(@PathVariable(value = "id") String quotationId)
			throws ResourceNotFoundException {
		QuotationForm quotation = quotationFormRepository.findById(quotationId)
				.orElseThrow(() -> new ResourceNotFoundException("QuotationForm not found for this id :: " + quotationId));

		quotationFormRepository.delete(quotation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/quotations")
	public void del(){
		quotationFormRepository.deleteAll();
	}

}