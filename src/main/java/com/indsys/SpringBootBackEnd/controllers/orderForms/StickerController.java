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
import com.indsys.SpringBootBackEnd.models.orderForms.Sticker;
import com.indsys.SpringBootBackEnd.repositories.orderForms.StickerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class StickerController {
	@Autowired
	private StickerRepository stickerRepository;

	@GetMapping("/sticker")
	public List<Sticker> getAllStickers() {
		return stickerRepository.findAll();
	}

	@GetMapping("/sticker/{id}")
	public ResponseEntity<Sticker> getStickerById(@PathVariable(value = "id") String stickerId)
			throws ResourceNotFoundException {
		Sticker sticker = stickerRepository.findById(stickerId)
				.orElseThrow(() -> new ResourceNotFoundException("Sticker not found for this id :: " + stickerId));
		return ResponseEntity.ok().body(sticker);
	}

	@PostMapping("/sticker")
	public Sticker createSticker(@Validated @RequestBody Sticker sticker) {
		return stickerRepository.save(sticker);
	}

	@PutMapping("/sticker/{id}")
	public ResponseEntity<Sticker> updateSticker(@PathVariable(value = "id") String stickerId,
			@Validated @RequestBody Sticker stickerDetails) throws ResourceNotFoundException {
				Sticker sticker = stickerRepository.findById(stickerId)
				.orElseThrow(() -> new ResourceNotFoundException("Sticker not found for this id :: " + stickerId));

		sticker.setUnitHeight(stickerDetails.getUnitHeight());
		sticker.setUnitWidth(stickerDetails.getUnitWidth());
		sticker.setDiameter(stickerDetails.getDiameter());
		sticker.setDocumentType(stickerDetails.getDocumentType());
		sticker.setColorInfo(stickerDetails.getColorInfo());
		sticker.setStickerType(stickerDetails.getStickerType());
		sticker.setRollColor(stickerDetails.getRollColor());
		sticker.setRollSpecification(stickerDetails.getRollSpecification());
		sticker.setRollSize(stickerDetails.getRollSize());
		sticker.setSampleCharge(stickerDetails.getSampleCharge());
		sticker.setSampleChargecollected(stickerDetails.getSampleChargecollected());
		sticker.setPrintType(stickerDetails.getPrintType());
		sticker.setComments(stickerDetails.getComments());
		sticker.setOrderType(stickerDetails.getOrderType());
		sticker.setExpectedQuantity(stickerDetails.getExpectedQuantity());
		sticker.setSampleRequest(stickerDetails.getSampleRequest());
		sticker.setFlex(stickerDetails.getFlex());
		sticker.setOffset(stickerDetails.getOffset());
		sticker.setIncoming(stickerDetails.getIncoming());
		sticker.setSamplePDate(stickerDetails.getSamplePDate());
		sticker.setExecutiveCode(stickerDetails.getExecutiveCode());
		sticker.setManager(stickerDetails.getManager());
		sticker.setDatetime(stickerDetails.getDatetime());
		sticker.setDispatch(stickerDetails.getDispatch());
		sticker.setRollCost(stickerDetails.getRollCost());
		sticker.setRollWastage(stickerDetails.getRollWastage());
		sticker.setStickerPrint(stickerDetails.getStickerPrint());
		sticker.setDigitalPrint(stickerDetails.getDigitalPrint());
		sticker.setFoil(stickerDetails.getFoil());
		sticker.setDie(stickerDetails.getDie());
		sticker.setFwdandPacking(stickerDetails.getFwdandPacking());
		sticker.setTotal(stickerDetails.getTotal());
		sticker.setMargin(stickerDetails.getMargin());
		sticker.setFinalCost(stickerDetails.getFinalCost());
		sticker.setTrimPiece(stickerDetails.getTrimPiece());
		sticker.setPlatesizeSticker(stickerDetails.getPlatesizeSticker());
		
		
	
		
		final Sticker updatedSticker = stickerRepository.save(sticker);
		return ResponseEntity.ok(updatedSticker);
	}

	@DeleteMapping("/sticker/{id}")
	public Map<String, Boolean> deleteSticker(@PathVariable(value = "id") String stickerId)
			throws ResourceNotFoundException {
				Sticker sticker = stickerRepository.findById(stickerId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + stickerId));

		stickerRepository.delete(sticker);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 