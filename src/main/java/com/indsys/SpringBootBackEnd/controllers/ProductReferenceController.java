package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
// import java.util.HashMap;
import java.util.List;
// import java.util.Map;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.ProductReference;
import com.indsys.SpringBootBackEnd.repositories.ProductReferenceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master")
public class ProductReferenceController {
	@Autowired
	private ProductReferenceRepository productReferenceRepository;

	@GetMapping("/productreference")
	public List<ProductReference> getAllProductReferences() {
		return productReferenceRepository.findAll();
	}

	@GetMapping("/productreference/printmax")
	public int printMax() {
		long zeroCheck = productReferenceRepository.count();
		if(zeroCheck != 0)
		{
			int max = productReferenceRepository.printMax();
			return max;
		}
		else
		{
			return 0;
		}
	}

	@GetMapping("/productreference/wovenmax")
	public int wovenMax() {
		long zeroCheck = productReferenceRepository.count();
		if(zeroCheck != 0)
		{
			int max = productReferenceRepository.wovenMax();
			return max;
		}
		else
		{
			return 0;
		} 
	}

	@GetMapping("/productreference/tagmax")
	public int tagMax() {
		long zeroCheck = productReferenceRepository.count();
		if(zeroCheck != 0)
		{
			int max = productReferenceRepository.tagMax();
			return max;
		}
		else
		{
			return 0;
		}
	}

	@GetMapping("/productreference/stickermax")
	public int stickerMax() {
		long zeroCheck = productReferenceRepository.count();
		if(zeroCheck != 0)
		{
			int max = productReferenceRepository.stickerMax();
			return max;
		}
		else
		{
			return 0;
		}
	}

	@GetMapping("/productreference/{id}")
	public ResponseEntity<ProductReference> getProductReferenceById(@PathVariable(value = "id") String productReferenceId)
			throws ResourceNotFoundException {
				ProductReference productReference = productReferenceRepository.findById(productReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Reference not found for this id :: " + productReferenceId));
		return ResponseEntity.ok().body(productReference);
	}

	@PostMapping("/productreference")
	public ProductReference createProductReference(@Validated @RequestBody ProductReference productReference) {
		return productReferenceRepository.save(productReference);
	}

	@PutMapping("/productreference/{id}")
	public ResponseEntity<ProductReference> updateProductReference(@PathVariable(value = "id") String productReferenceId,
			@Validated @RequestBody ProductReference productReferenceDetails) throws ResourceNotFoundException {
				ProductReference productReference = productReferenceRepository.findById(productReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Reference not found for this id :: " + productReferenceId));

				productReference.setPrintcolorname(productReferenceDetails.getPrintcolorname());
				productReference.setTagcolorname(productReferenceDetails.getTagcolorname());
				productReference.setStickercolorname(productReferenceDetails.getStickercolorname());
				productReference.setWovencolorname(productReferenceDetails.getWovencolorname());

				productReference.setWovenNum(productReferenceDetails.getWovenNum());
				productReference.setPrintNum(productReferenceDetails.getPrintNum());
				productReference.setTagNum(productReferenceDetails.getTagNum());
				productReference.setStickerNum(productReferenceDetails.getStickerNum());

				productReference.setPrintreferencenumber(productReferenceDetails.getPrintreferencenumber());
				productReference.setTagreferencenumber(productReferenceDetails.getTagreferencenumber());
				productReference.setStickerreferencenumber(productReferenceDetails.getStickerreferencenumber());
				productReference.setWovenreferencenumber(productReferenceDetails.getWovenreferencenumber());

				productReference.setWovennext(productReferenceDetails.getWovennext());
				productReference.setStickernext(productReferenceDetails.getStickernext());
				productReference.setTagnext(productReferenceDetails.getTagnext());
				productReference.setPrintnext(productReferenceDetails.getPrintnext());
				
		final ProductReference updatedMcolor = productReferenceRepository.save(productReference);
		return ResponseEntity.ok(updatedMcolor);
	}

	@DeleteMapping("/productreference/{id}")
	public Map<String, Boolean> deleteProductReference(@PathVariable(value = "id") String productReferenceId)
			throws ResourceNotFoundException {
				ProductReference productReference = productReferenceRepository.findById(productReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + productReferenceId));

				productReferenceRepository.delete(productReference);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
 