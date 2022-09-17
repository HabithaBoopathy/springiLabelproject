package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
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
import com.indsys.SpringBootBackEnd.models.Login;
import com.indsys.SpringBootBackEnd.repositories.LoginRepository;


@Document("Ships")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class LoginController {
	@Autowired
	private LoginRepository loginRepository;

	@GetMapping("/logins")
	public List<Login> getAllLogins() {
		return loginRepository.findAll();
	}

	@GetMapping("/logins/{id}")
	public ResponseEntity<Login> getLoginById(@PathVariable(value = "id") String loginId)
			throws ResourceNotFoundException {
		Login login = loginRepository.findById(loginId)
				.orElseThrow(() -> new ResourceNotFoundException("Get Login not found for this id :: " + loginId));
		return ResponseEntity.ok().body(login);
	}

	@PostMapping("/logins")
	public Login createLogin(@Validated @RequestBody Login login) {
		return loginRepository.save(login);
	}

	@PutMapping("/logins/{id}")
	public ResponseEntity<Login> updateLogin(@PathVariable(value = "id") String loginId,
			@Validated @RequestBody Login loginDetails) throws ResourceNotFoundException {
				Login login = loginRepository.findById(loginId)
				.orElseThrow(() -> new ResourceNotFoundException("Update Login not found for this id :: " + loginId));

		login.setUsername(loginDetails.getUsername());
		login.setPass(loginDetails.getPass());
		final Login updatedLogin = loginRepository.save(login);
		return ResponseEntity.ok(updatedLogin);
	}

	@DeleteMapping("/logins/{id}")
	public Map<String, Boolean> deleteLogin(@PathVariable(value = "id") String loginId)
			throws ResourceNotFoundException {
				Login login = loginRepository.findById(loginId)
				.orElseThrow(() -> new ResourceNotFoundException("Delete Login not found for this id :: " + loginId));

		loginRepository.delete(login);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
