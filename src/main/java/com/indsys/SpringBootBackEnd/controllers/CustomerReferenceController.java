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
import com.indsys.SpringBootBackEnd.models.CustomerReference;
import com.indsys.SpringBootBackEnd.repositories.CustomerReferenceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class CustomerReferenceController {
	@Autowired
	private CustomerReferenceRepository customerReferenceRepository;

	@GetMapping("/customerreference")
	public List<CustomerReference> getAllCustomerReferences() {
		return customerReferenceRepository.findAll();
	}

	@GetMapping("/customerreference/{id}")
	public ResponseEntity<CustomerReference> getCustomerReferenceById(@PathVariable(value = "id") String customerReferenceId)
			throws ResourceNotFoundException {
				CustomerReference customerReference = customerReferenceRepository.findById(customerReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Reference not found for this id :: " + customerReferenceId));
		return ResponseEntity.ok().body(customerReference);
	}

	@PostMapping("/customerreference")
	public CustomerReference createCustomerReference(@Validated @RequestBody CustomerReference customerReference) {
		return customerReferenceRepository.save(customerReference);
	}

	@PutMapping("/customerreference/{id}")
	public ResponseEntity<CustomerReference> updateCustomerReference(@PathVariable(value = "id") String customerReferenceId,
			@Validated @RequestBody CustomerReference customerReferenceDetails) throws ResourceNotFoundException {
				CustomerReference customerReference = customerReferenceRepository.findById(customerReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Reference not found for this id :: " + customerReferenceId));

				customerReference.setCustomername(customerReferenceDetails.getCustomername());
				customerReference.setCustomernum(customerReferenceDetails.getCustomernum());
				customerReference.setCustomerreference(customerReferenceDetails.getCustomerreference());
		final CustomerReference updatedMcolor = customerReferenceRepository.save(customerReference);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/customerreference/{id}")
	public Map<String, Boolean> deleteCustomerReference(@PathVariable(value = "id") String customerReferenceId)
			throws ResourceNotFoundException {
				CustomerReference customerReference = customerReferenceRepository.findById(customerReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + customerReferenceId));

				customerReferenceRepository.delete(customerReference);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 