package com.indsys.SpringBootBackEnd.controllers.orderForms;

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
import com.indsys.SpringBootBackEnd.models.orderForms.Quotation;
import com.indsys.SpringBootBackEnd.repositories.orderForms.QuotationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class QuotationController {
	@Autowired
	private QuotationRepository quotationRepository;

	@GetMapping("/quotation")
	public List<Quotation> getAllQuotations() {
		return quotationRepository.findAll();
	}

	@GetMapping("/quotation/{cid}")
	public ResponseEntity<Quotation> getQuotationById(@PathVariable(value = "cid") String quotationId)
			throws ResourceNotFoundException {
		Quotation quotation = quotationRepository.findById(quotationId)
				.orElseThrow(() -> new ResourceNotFoundException("Quotation not found for this cid :: " + quotationId));
		return ResponseEntity.ok().body(quotation);
	}

	@PostMapping("/quotation")
	public Quotation createQuotation(@Validated @RequestBody Quotation quotation) {
		return quotationRepository.save(quotation);
	}

	@PutMapping("/quotation/{cid}")
	public ResponseEntity<Quotation> updateQuotation(@PathVariable(value = "cid") String cid,
			@Validated @RequestBody Quotation quotationDetails) throws ResourceNotFoundException {
				Quotation quotation = quotationRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Quotation not found for this cid :: " + cid));

		quotation.setItemDescription(quotationDetails.getItemDescription());
		quotation.setHsn(quotationDetails.getHsn());
		quotation.setQuantityRange(quotationDetails.getQuantityRange());
		quotation.setRate(quotationDetails.getRate());
		quotation.setTermsAndConditions(quotationDetails.getTermsAndConditions());

		
		final Quotation updatedQuotation = quotationRepository.save(quotation);
		return ResponseEntity.ok(updatedQuotation);
	}

	@DeleteMapping("/quotation/{cid}")
	public Map<String, Boolean> deleteQuotation(@PathVariable(value = "cid") String quotationId)
			throws ResourceNotFoundException {
				Quotation quotation = quotationRepository.findById(quotationId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this cid :: " + quotationId));

		quotationRepository.delete(quotation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 