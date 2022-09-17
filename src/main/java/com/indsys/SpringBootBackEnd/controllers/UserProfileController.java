package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.indsys.SpringBootBackEnd.models.UserProfile;
import com.indsys.SpringBootBackEnd.repositories.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserProfileController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<UserProfile> getAllUserProfiles() {
		return userRepository.findAll();
	}

	@GetMapping("/users/email/{v}")
	public UserProfile getByVerification(@PathVariable("v") String v){
		return userRepository.getByloginId(v);
	}

	@GetMapping("/users/checklogin/{x}/{y}")
	public UserProfile getByVerification2(@PathVariable("x") String x, @PathVariable("y") String y){
		return userRepository.getByLoginIDandPassword(x,y);
	}

	@GetMapping("/users/checkaccess/{x}")
	public List<UserProfile> getByVerification3(@PathVariable("x") String x){
		return userRepository.getByAccessRightsAndTrimTypes(x);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserProfile> getUserProfileById(@PathVariable(value = "id") String userId)
			throws ResourceNotFoundException {
		UserProfile user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserProfile not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users")
	public UserProfile createUserProfile(@Validated @RequestBody UserProfile user) {
		return userRepository.save(user);
	}

	@GetMapping("/users/deactivate/{id}")
	public Boolean deactivateUser(@PathVariable("id") String id){
		Optional<UserProfile> userProfile = userRepository.findById(id);
		if(userProfile.isPresent()){
			UserProfile userProfile1 = userProfile.get();
			userProfile1.setStatus("deactivated");
			userRepository.save(userProfile1);
			return true;
		}else{
			return false;
		}
	}

	@GetMapping("/users/activate/{id}")
	public Boolean activateUser(@PathVariable("id") String id){
		Optional<UserProfile> userProfile = userRepository.findById(id);
		if(userProfile.isPresent()){
			UserProfile userProfile1 = userProfile.get();
			userProfile1.setStatus("");
			userRepository.save(userProfile1);
			return true;
		}else{
			return false;
		}
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserProfile> updateUserProfile(@PathVariable(value = "id") String userId,
			@Validated @RequestBody UserProfile userDetails) throws ResourceNotFoundException {
				UserProfile user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserProfile not found for this id :: " + userId));

		user.setUsername(userDetails.getUsername());
		user.setLoginId(userDetails.getLoginId());
		user.setPassword(userDetails.getPassword());
		user.setAccessRights(userDetails.getAccessRights());
		user.setTrimTypes(userDetails.getTrimTypes());
		user.setCustomerName(userDetails.getCustomerName());
		user.setLogAccess
		(userDetails.getLogAccess());
		final UserProfile updatedUserProfile = userRepository.save(user);
		return ResponseEntity.ok(updatedUserProfile);
	}

	// @PutMapping(value="/users/{id}")
    // public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id,
    //                                        @Validated @RequestBody Todo todo) {
    //     return todoRepository.findById(id)
    //             .map(todoData -> {
    //                 todoData.setTitle(todo.getTitle());
    //                 todoData.setCompleted(todo.getCompleted());
    //                 Todo updatedTodo = todoRepository.save(todoData);
    //                 return ResponseEntity.ok().body(updatedTodo);
    //             }).orElse(ResponseEntity.notFound().build());
    // }

	@DeleteMapping("/users/email/delete/{email}")
	public Boolean deleteUserByEmail(@PathVariable("email") String email){
		UserProfile userProfile =  userRepository.getByloginId(email);

		if(userProfile != null){
			userRepository.deleteById(userProfile.getId());
			return true;
		}else{
			return false;
		}

	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUserProfile(@PathVariable(value = "id") String userId)
			throws ResourceNotFoundException {
				UserProfile user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserProfile not found for this id :: " + userId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
    
}