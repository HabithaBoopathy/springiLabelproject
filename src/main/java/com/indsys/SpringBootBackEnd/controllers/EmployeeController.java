package com.indsys.SpringBootBackEnd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.indsys.SpringBootBackEnd.models.UserProfile;
import com.indsys.SpringBootBackEnd.repositories.UserRepository;
import org.eclipse.jetty.server.Authentication;
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
import com.indsys.SpringBootBackEnd.models.Employee;
import com.indsys.SpringBootBackEnd.repositories.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/active")
	public List<Employee> getAllActiveEmployees() {
		return employeeRepository.getAllActiveCustomers();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@GetMapping("/employees/verify/{v}")
	public List<Employee> getByVerification(@PathVariable("v") String v){
		return employeeRepository.getByVerificationStatus(v);
	}

	@GetMapping("/employees/customerref/{v}")
	public Employee getByCustomerReferenceCheck(@PathVariable("v") String v){
		return employeeRepository.getByCustomerReference(v);
	}

	@GetMapping("/employees/executivename/{v}")
	public List<Employee> getByExecutiveName(@PathVariable("v") String v){
		return employeeRepository.getByExecutiveName(v);
	}

	@GetMapping("/employees/executivecode/{v}")
	public List<Employee> getByExecutiveCode1(@PathVariable("v") String v){
		return employeeRepository.getByExecutiveCode(v);
	}

	@GetMapping("/employees/executiveCodeAndActive/{execCode}")
	public List<Employee> getByExecutiveCodeAndActive(@PathVariable("execCode") String execCode){
		return employeeRepository.getByExecutiveCodeAndActive(execCode);
	}

	@GetMapping("/employees/customernumber/{v}")
	public Employee getByCustomerNumberCheck(@PathVariable("v") int v){
		return employeeRepository.getByCustomerNumber(v);
	}

	@GetMapping("/employees/employeeemail/{v}")
	public Employee getByEmployeeEmail(@PathVariable("v") String v){
		return employeeRepository.getByEmployeeEmail(v);
	}

	@GetMapping("/employees/customerreferenceandname/executivename/{v}")
	public List<Employee> getCustomerReferenceandName(@PathVariable("v") String v){
		return employeeRepository.getCustomerReferenceAndNameByExecutiveCode(v);
	}

	@GetMapping("/employees/deactivate/{id}")
	public UserProfile deactivateUser(@PathVariable("id") String id){
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isPresent()){
			Employee employee = employeeOptional.get();
			employee.setIsDisabled(1);
			employeeRepository.save(employee);

			UserProfile userProfile = userRepository.getByloginId(employee.getEmailId());
			return userProfile;
		}else{
			return null;
		}
	}

	@GetMapping("/employees/activate/{id}")
	public UserProfile activateUser(@PathVariable("id") String id){
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isPresent()){
			Employee employee = employeeOptional.get();
			employee.setIsDisabled(0);
			employeeRepository.save(employee);

			UserProfile userProfile = userRepository.getByloginId(employee.getEmailId());
			return userProfile;
		}else{
			return null;
		}
	}

	@PostMapping("/employees/all")
	public List<Employee> importEmployee(@Validated @RequestBody List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/update")
	public Employee updateEmployeeNew(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String employeeId,
			@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
				Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setAlternateemailId(employeeDetails.getAlternateemailId());     
		employee.setCompanyname(employeeDetails.getCompanyname());
		employee.setCustomername(employeeDetails.getCustomername());
		employee.setPhone(employeeDetails.getPhone());
		employee.setWebsite(employeeDetails.getWebsite());
		employee.setRadio(employeeDetails.getRadio());
		employee.setStreet1(employeeDetails.getStreet1());
		employee.setStreet2(employeeDetails.getStreet2());
		employee.setCity(employeeDetails.getCity());
		employee.setZipcode(employeeDetails.getZipcode());
		employee.setState(employeeDetails.getState());
		employee.setCountry(employeeDetails.getCountry());
		employee.setPaymentTerms(employeeDetails.getPaymentTerms());
		employee.setShipmentTerms(employeeDetails.getShipmentTerms());
		employee.setGstin(employeeDetails.getGstin());
		employee.setCustomerreference(employeeDetails.getCustomerreference());
		employee.setCustomernum(employeeDetails.getCustomernum());
		employee.setExecutiveName(employeeDetails.getExecutiveName());
		employee.setExecutiveCode(employeeDetails.getExecutiveCode());
		employee.setCustomerEmail(employeeDetails.getCustomerEmail());
//		employee.setMerchandiser(employeeDetails.getMerchandiser());
		employee.setTerritory(employeeDetails.getTerritory());
		employee.setCustomerCategory(employeeDetails.getCustomerCategory());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@PutMapping("/customerverification/{id}")
	public ResponseEntity<Employee> customerVerification(@PathVariable(value = "id") String employeeId,
			@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
				Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeDetails.getEmailId();
		employeeDetails.getAlternateemailId();     
		employeeDetails.getCompanyname();
		employeeDetails.getCustomername();
		employeeDetails.getPhone();
		employeeDetails.getWebsite();
		employeeDetails.getRadio();
		employeeDetails.getStreet1();
		employeeDetails.getStreet2();
		employeeDetails.getCity();
		employeeDetails.getZipcode();
		employeeDetails.getState();
		employeeDetails.getCountry();
		employeeDetails.getPaymentTerms();
		employeeDetails.getShipmentTerms();
		employeeDetails.getGstin();
		employeeDetails.getCustomerreference();
		employeeDetails.getCustomernum();
		employeeDetails.getExecutiveName();
		employeeDetails.getExecutiveCode();
//		employeeDetails.getMerchandiser();
		employee.setVerificationStatus(employeeDetails.getVerificationStatus());
		employeeDetails.getTerritory();
		employeeDetails.getCustomerCategory();

		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String employeeId)
			throws ResourceNotFoundException {
				Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
