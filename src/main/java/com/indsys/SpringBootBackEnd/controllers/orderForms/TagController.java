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
import com.indsys.SpringBootBackEnd.models.orderForms.Tag;
import com.indsys.SpringBootBackEnd.repositories.orderForms.TagRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class TagController {
	@Autowired
	private TagRepository tagRepository;

	@GetMapping("/tag")
	public List<Tag> getAllTags() {
		return tagRepository.findAll();
	}

	@GetMapping("/tag/{id}")
	public ResponseEntity<Tag> getTagById(@PathVariable(value = "id") String tagId)
			throws ResourceNotFoundException {
		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new ResourceNotFoundException("Tag not found for this id :: " + tagId));
		return ResponseEntity.ok().body(tag);
	}

	@PostMapping("/tag")
	public Tag createTag(@Validated @RequestBody Tag tag) {
		return tagRepository.save(tag);
	}

	@PutMapping("/tag/{id}")
	public ResponseEntity<Tag> updateTag(@PathVariable(value = "id") String tagId,
			@Validated @RequestBody Tag tagDetails) throws ResourceNotFoundException {
				Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new ResourceNotFoundException("Tag not found for this id :: " + tagId));

		tag.setUnitHeight(tagDetails.getUnitHeight());
		tag.setUnitWidth(tagDetails.getUnitWidth());
		tag.setTagDevType(tagDetails.getTagDevType());
		tag.setDocumentType(tagDetails.getDocumentType());
		tag.setColorInfo(tagDetails.getColorInfo());
		tag.setRunningBoardSize(tagDetails.getRunningBoardSize());
		tag.setNameOfTheBoard(tagDetails.getNameOfTheBoard());
		tag.setBoardSpecification(tagDetails.getBoardSpecification());
		tag.setQuality(tagDetails.getQuality());
		tag.setBoardGSM(tagDetails.getBoardGSM());
		tag.setFsc(tagDetails.getFsc());
		tag.setPrintType(tagDetails.getPrintType());
		tag.setColor(tagDetails.getColor());
		tag.setOrderType(tagDetails.getOrderType());
		tag.setExpectedQuantity(tagDetails.getExpectedQuantity());
		tag.setStatus(tagDetails.getStatus());
		tag.setFinishing(tagDetails.getFinishing());
		tag.setExpectedDate(tagDetails.getExpectedDate());
		tag.setFolding(tagDetails.getFolding());
		tag.setApproval(tagDetails.getApproval());
		tag.setComments(tagDetails.getComments());
		tag.setNoOfPlates(tagDetails.getNoOfPlates());
		tag.setNegativePositive(tagDetails.getNegativePositive());
		tag.setFoilEmbossScreen(tagDetails.getFoilEmbossScreen());
		tag.setDie(tagDetails.getDie());
		tag.setPlatesize(tagDetails.getPlatesize());
		tag.setPrintColorMatching(tagDetails.getPrintColorMatching());
		tag.setFoilFace(tagDetails.getFoilFace());
		tag.setFoilReverse(tagDetails.getFoilReverse());
		tag.setFoilColor(tagDetails.getFoilColor());
		tag.setUvFace(tagDetails.getUvFace());
		tag.setUvReverse(tagDetails.getUvReverse());
		tag.setUvNoOfScreens(tagDetails.getUvNoOfScreens());
		tag.setvMatt(tagDetails.getvMatt());
		tag.setvGloss(tagDetails.getvGloss());
		tag.setvFace(tagDetails.getvFace());
		tag.setvReverse(tagDetails.getvReverse());
		tag.setvOthers(tagDetails.getvOthers());
		tag.setlMatt(tagDetails.getlMatt());
		tag.setlGloss(tagDetails.getlGloss());
		tag.setlFace(tagDetails.getlFace());
		tag.setlReverse(tagDetails.getlReverse());
		tag.setlOthers(tagDetails.getlOthers());
		tag.setStraightCut(tagDetails.getStraightCut());
		tag.setHoleSize(tagDetails.getHoleSize());
		tag.setPerforation(tagDetails.getPerforation());
		tag.setCreasing(tagDetails.getCreasing());
		tag.setDesignCut(tagDetails.getDesignCut());
		tag.setString(tagDetails.getString());
		tag.setEyeletColorAndLength(tagDetails.getEyeletColorAndLength());
		tag.setIfOthers(tagDetails.getIfOthers());
		tag.setHookColorAndLength(tagDetails.getHookColorAndLength());
		tag.setBoardCost(tagDetails.getBoardCost());
		tag.setDesignFileName(tagDetails.getDesignFileName());
		tag.setDigitalPrint(tagDetails.getDigitalPrint());
		tag.setOffsetPrint(tagDetails.getOffsetPrint());
		tag.setFoil(tagDetails.getFoil());
		tag.setUv(tagDetails.getUv());
		tag.setEmboss(tagDetails.getEmboss());
		tag.setVarnish(tagDetails.getVarnish());
		tag.setLamination(tagDetails.getLamination());
		tag.setPasting(tagDetails.getPasting());
		tag.setDie2(tagDetails.getDie2());
		
		
		final Tag updatedTag = tagRepository.save(tag);
		return ResponseEntity.ok(updatedTag);
	}

	@DeleteMapping("/tag/{id}")
	public Map<String, Boolean> deleteTag(@PathVariable(value = "id") String tagId)
			throws ResourceNotFoundException {
				Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + tagId));

		tagRepository.delete(tag);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 