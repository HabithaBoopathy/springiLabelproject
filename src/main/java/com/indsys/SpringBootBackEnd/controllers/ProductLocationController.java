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
import com.indsys.SpringBootBackEnd.models.ProductLocation;
import com.indsys.SpringBootBackEnd.repositories.ProductLocationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class ProductLocationController {
	@Autowired
	private ProductLocationRepository productLocationRepository;

	@GetMapping("/productlocation")
	public List<ProductLocation> getAllProductLocations() {
		return productLocationRepository.findAll();
	}

	@GetMapping("/productlocation/locationname/{v}")
	public ProductLocation getByLocationName(@PathVariable("v") String v){
		return productLocationRepository.getByLocationName(v);
	}

	@GetMapping("/productlocation/{id}")
	public ResponseEntity<ProductLocation> getProductLocationById(@PathVariable(value = "id") String productLocationId)
			throws ResourceNotFoundException {
				ProductLocation productLocation = productLocationRepository.findById(productLocationId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Location not found for this id :: " + productLocationId));
		return ResponseEntity.ok().body(productLocation);
	}

	@PostMapping("/productlocation")
	public ProductLocation createProductLocation(@Validated @RequestBody ProductLocation productLocation) {
		return productLocationRepository.save(productLocation);
	}

	@PutMapping("/productlocation/{id}")
	public ResponseEntity<ProductLocation> updateProductLocation(@PathVariable(value = "id") String productLocationId,
			@Validated @RequestBody ProductLocation productLocationDetails) throws ResourceNotFoundException {
				ProductLocation productLocation = productLocationRepository.findById(productLocationId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Location not found for this id :: " + productLocationId));

				productLocation.setLocation(productLocationDetails.getLocation());
				productLocation.setPrinted(productLocationDetails.getPrinted());
				productLocation.setSticker(productLocationDetails.getSticker());
				productLocation.setTag(productLocationDetails.getTag());
				productLocation.setWoven(productLocationDetails.getWoven());
		final ProductLocation updatedMcolor = productLocationRepository.save(productLocation);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/productlocation/{id}")
	public Map<String, Boolean> deleteProductLocation(@PathVariable(value = "id") String productLocationId)
			throws ResourceNotFoundException {
				ProductLocation productLocation = productLocationRepository.findById(productLocationId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + productLocationId));

				productLocationRepository.delete(productLocation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 