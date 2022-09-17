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
import com.indsys.SpringBootBackEnd.models.orderForms.Printed;
import com.indsys.SpringBootBackEnd.repositories.orderForms.PrintedRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class PrintedController {
	@Autowired
	private PrintedRepository printedRepository;

	@GetMapping("/printed")
	public List<Printed> getAllPrinteds() {
		return printedRepository.findAll();
	}

	@GetMapping("/printed/{id}")
	public ResponseEntity<Printed> getPrintedById(@PathVariable(value = "id") String printedId)
			throws ResourceNotFoundException {
		Printed printed = printedRepository.findById(printedId)
				.orElseThrow(() -> new ResourceNotFoundException("Printed not found for this id :: " + printedId));
		return ResponseEntity.ok().body(printed);
	}

	@PostMapping("/printed")
	public Printed createPrinted(@Validated @RequestBody Printed printed) {
		return printedRepository.save(printed);
	}

	@PutMapping("/printed/{id}")
	public ResponseEntity<Printed> updatePrinted(@PathVariable(value = "id") String printedId,
			@Validated @RequestBody Printed printedDetails) throws ResourceNotFoundException {
				Printed printed = printedRepository.findById(printedId)
				.orElseThrow(() -> new ResourceNotFoundException("Printed not found for this id :: " + printedId));

		printed.setUnit(printedDetails.getUnit());
		printed.setUnitHeight(printedDetails.getUnitHeight());
		printed.setUnitWidth(printedDetails.getUnitWidth());
		printed.setExpectedQuantity(printedDetails.getExpectedQuantity());
		printed.setFolding(printedDetails.getFolding());
		printed.setSpecialInstruction(printedDetails.getSpecialInstruction());
		printed.setRemarks(printedDetails.getRemarks());
		printed.setColor(printedDetails.getColor());
		printed.setOrderType(printedDetails.getOrderType());
		printed.setColorInformation(printedDetails.getColorInformation());
		printed.setStatus(printedDetails.getStatus());
		printed.setFinishing(printedDetails.getFinishing());
		printed.setLabelType(printedDetails.getLabelType());
		printed.setApprovalType(printedDetails.getApprovalType());
		printed.setIncoming(printedDetails.getIncoming());
		printed.setSamplePDate(printedDetails.getSamplePDate());
		printed.setExecutiveCode(printedDetails.getExecutiveCode());
		printed.setManager(printedDetails.getManager());
		printed.setDateTime(printedDetails.getDateTime());
		printed.setDispatch(printedDetails.getDispatch());
		printed.setSampleReceived(printedDetails.getSampleReceived());
		printed.setPm(printedDetails.getPm());
		printed.setSampleName(printedDetails.getSampleName());
		printed.setSystem(printedDetails.getSystem());
		printed.setSampleBlock(printedDetails.getSampleBlock());
		printed.setSamplingDate(printedDetails.getSamplingDate());
		printed.setCrlimitStatus(printedDetails.getCrlimitStatus());
		printed.setDesignFileName(printedDetails.getDesignFileName());
		printed.setMachine(printedDetails.getMachine());
		printed.setWidth(printedDetails.getWidth());
		printed.setQuality(printedDetails.getQuality());
		printed.setLength(printedDetails.getLength());
		printed.setSinglePrinting(printedDetails.getSinglePrinting());
		printed.setDoublePrinting(printedDetails.getDoublePrinting());
		printed.setColorOption(printedDetails.getColorOption());
		printed.setNoOfcolors(printedDetails.getNoOfcolors());
		printed.setAdditionalWork(printedDetails.getAdditionalWork());
		
		
		printed.setSampleBlock(printedDetails.getSampleBlock());
		printed.setNoOfRepeatsPrinted(printedDetails.getNoOfRepeatsPrinted());
		printed.setWidthPrinted(printedDetails.getWidthPrinted());
		
		
	

		
		
		
		final Printed updatedPrinted = printedRepository.save(printed);
		return ResponseEntity.ok(updatedPrinted);
	}

	@DeleteMapping("/printed/{id}")
	public Map<String, Boolean> deletePrinted(@PathVariable(value = "id") String printedId)
			throws ResourceNotFoundException {
				Printed printed = printedRepository.findById(printedId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + printedId));

		printedRepository.delete(printed);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 