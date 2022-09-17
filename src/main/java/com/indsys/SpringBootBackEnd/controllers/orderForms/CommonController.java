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
import com.indsys.SpringBootBackEnd.models.orderForms.Common;
import com.indsys.SpringBootBackEnd.repositories.orderForms.CommonRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class CommonController {
	@Autowired
	private CommonRepository commonRepository;

	@GetMapping("/common")
	public List<Common> getAllCommons() {
		return commonRepository.findAll();
	}

	@GetMapping("/common/{cid}")
	public ResponseEntity<Common> getCommonById(@PathVariable(value = "cid") String commonId)
			throws ResourceNotFoundException {
		Common common = commonRepository.findById(commonId)
				.orElseThrow(() -> new ResourceNotFoundException("Common not found for this cid :: " + commonId));
		return ResponseEntity.ok().body(common);
	}

	@PostMapping("/common")
	public Common createCommon(@Validated @RequestBody Common common) {
		return commonRepository.save(common);
	}

	@PutMapping("/common/{cid}")
	public ResponseEntity<Common> updateCommon(@PathVariable(value = "cid") String cid,
			@Validated @RequestBody Common commonDetails) throws ResourceNotFoundException {
				Common common = commonRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Common not found for this cid :: " + cid));

		common.setDate(commonDetails.getDate());
		common.setOldRefNo(commonDetails.getOldRefNo());
		common.setName(commonDetails.getName());
		common.setSampleName(commonDetails.getSampleName());
		common.setContactPerson(commonDetails.getContactPerson());
		common.setPhone(commonDetails.getPhone());
		common.setEmail(commonDetails.getEmail());
		common.setRefNo(commonDetails.getRefNo());
		common.setExecName(commonDetails.getExecName());
		
		final Common updatedCommon = commonRepository.save(common);
		return ResponseEntity.ok(updatedCommon);
	}

	@DeleteMapping("/common/{cid}")
	public Map<String, Boolean> deleteCommon(@PathVariable(value = "cid") String commonId)
			throws ResourceNotFoundException {
				Common common = commonRepository.findById(commonId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this cid :: " + commonId));

		commonRepository.delete(common);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 