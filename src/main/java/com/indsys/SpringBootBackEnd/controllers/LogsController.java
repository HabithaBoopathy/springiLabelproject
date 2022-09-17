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
import com.indsys.SpringBootBackEnd.models.Logs;
import com.indsys.SpringBootBackEnd.repositories.LogsRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LogsController {
	@Autowired
	private LogsRepository logRepository;

	@GetMapping("/logs")
	public List<Logs> getAllLogs() {
		return logRepository.findAll();
	}

	@GetMapping("/logs/{id}")
	public ResponseEntity<Logs> getLogById(@PathVariable(value = "id") String logId)
			throws ResourceNotFoundException {
		Logs log = logRepository.findById(logId)
				.orElseThrow(() -> new ResourceNotFoundException("Log not found for this id :: " + logId));
		return ResponseEntity.ok().body(log);
	}

	@PostMapping("/logs")
	public Logs createLog(@Validated @RequestBody Logs log) {
		return logRepository.save(log);
	}

	@PutMapping("/logs/{id}")
	public ResponseEntity<Logs> updateLog(@PathVariable(value = "id") String logId,
			@Validated @RequestBody Logs logDetails) throws ResourceNotFoundException {
				Logs log = logRepository.findById(logId)
				.orElseThrow(() -> new ResourceNotFoundException("Log not found for this id :: " + logId));

		log.setLogAccess(logDetails.getLogAccess());
		log.setLogNum(logDetails.getLogNum());
		final Logs updatedLog = logRepository.save(log);
		return ResponseEntity.ok(updatedLog);
	}

	@DeleteMapping("/logs/{id}")
	public Map<String, Boolean> deleteLog(@PathVariable(value = "id") String logId)
			throws ResourceNotFoundException {
				Logs log = logRepository.findById(logId)
				.orElseThrow(() -> new ResourceNotFoundException("Log not found for this id :: " + logId));

		logRepository.delete(log);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
    
}