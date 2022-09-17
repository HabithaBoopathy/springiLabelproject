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
import com.indsys.SpringBootBackEnd.models.orderForms.Woven;
import com.indsys.SpringBootBackEnd.repositories.orderForms.WovenRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class WovenController {
	@Autowired
	private WovenRepository wovenRepository;

	@GetMapping("/woven")
	public List<Woven> getAllwovens() {
		return wovenRepository.findAll();
	}

	@GetMapping("/woven/{id}")
	public ResponseEntity<Woven> getwovenById(@PathVariable(value = "id") String wovenId)
			throws ResourceNotFoundException {
		Woven woven = wovenRepository.findById(wovenId)
				.orElseThrow(() -> new ResourceNotFoundException("woven not found for this id :: " + wovenId));
		return ResponseEntity.ok().body(woven);
	}

	@PostMapping("/woven")
	public Woven createwoven(@Validated @RequestBody Woven woven) {
		return wovenRepository.save(woven);
	}

	@PutMapping("/woven/{id}")
	public ResponseEntity<Woven> updatewoven(@PathVariable(value = "id") String wovenId,
			@Validated @RequestBody Woven wovenDetails) throws ResourceNotFoundException {
				Woven woven = wovenRepository.findById(wovenId)
				.orElseThrow(() -> new ResourceNotFoundException("woven not found for this id :: " + wovenId));

		woven.setUnit(wovenDetails.getUnit());
		woven.setUnitHeight(wovenDetails.getUnitHeight());
		woven.setUnitWidth(wovenDetails.getUnitWidth());
		woven.setExpectedQuantity(wovenDetails.getExpectedQuantity());
		woven.setExpectedDate(wovenDetails.getExpectedDate());
		woven.setFolding(wovenDetails.getFolding());
		woven.setSpecialInstruction(wovenDetails.getSpecialInstruction());
		woven.setRemarks(wovenDetails.getRemarks());
		woven.setColor(wovenDetails.getColor());
		woven.setOrderType(wovenDetails.getOrderType());
		woven.setColorInfo(wovenDetails.getColorInfo());
		woven.setStatus(wovenDetails.getStatus());
		woven.setFinishing(wovenDetails.getFinishing());
		woven.setLabelType(wovenDetails.getLabelType());
		woven.setApprovalType(wovenDetails.getApprovalType());
		woven.setIncoming(wovenDetails.getIncoming());
		woven.setSamplePDate(wovenDetails.getSamplePDate());
		woven.setExecutiveCode(wovenDetails.getExecutiveCode());
		woven.setManager(wovenDetails.getManager());
		woven.setDateTime(wovenDetails.getDateTime());
		woven.setDispatchDateTime(wovenDetails.getDispatchDateTime());
		woven.setSampleRecDateTime(wovenDetails.getSampleRecDateTime());
		woven.setPcm(wovenDetails.getPcm());
		woven.setSampleName(wovenDetails.getSampleName());
		woven.setSystem(wovenDetails.getSystem());
		woven.setTp(wovenDetails.getTp());
		woven.setSamplingDate(wovenDetails.getSamplingDate());
		woven.setCrLimitStatus(wovenDetails.getCrLimitStatus());
		woven.setDesigner(wovenDetails.getDesigner());
		woven.setMachine(wovenDetails.getMachine());
		woven.setWidth(wovenDetails.getWidth());
		woven.setQuality(wovenDetails.getQuality());
		woven.setLength(wovenDetails.getLength());
		woven.setX(wovenDetails.getX());
		woven.setColorOptionToBeUsed(wovenDetails.getColorOptionToBeUsed());
		woven.setY(wovenDetails.getY());
		woven.setNoOfRepeats(wovenDetails.getNoOfRepeats());
		woven.setAdditionalWork(wovenDetails.getAdditionalWork());
		woven.setWastage(wovenDetails.getWastage());
		woven.setColorMatching(wovenDetails.getColorMatching());
		woven.setWarpTension(wovenDetails.getWarpTension());
		woven.setDoctype(wovenDetails.getDoctype());
		
		final Woven updatedwoven = wovenRepository.save(woven);
		return ResponseEntity.ok(updatedwoven);
	}

	@DeleteMapping("/woven/{id}")
	public Map<String, Boolean> deletewoven(@PathVariable(value = "id") String wovenId)
			throws ResourceNotFoundException {
				Woven woven = wovenRepository.findById(wovenId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + wovenId));

		wovenRepository.delete(woven);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 