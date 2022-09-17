package com.indsys.SpringBootBackEnd.controllers;

import java.util.List;
import java.util.Optional;

import com.indsys.SpringBootBackEnd.models.Company;
import com.indsys.SpringBootBackEnd.repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/master/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/create")
    public Company createCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @PutMapping("/update")
    public Company updateCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Company getCompanyById(@PathVariable("id") String id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }


}