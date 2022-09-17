package com.indsys.SpringBootBackEnd.v2.controllers;

import com.indsys.SpringBootBackEnd.v2.models.Company;
import com.indsys.SpringBootBackEnd.v2.repositories.CompanyRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/master/company/v2")
@CrossOrigin(origins = "*")
public class CompanyControllerV2 {

    @Autowired
    CompanyRepositoryV2 companyRepository;

    @PostMapping("/create")
    public Company createCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @GetMapping("/id/{id}")
    public Company getById(@PathVariable("id") String id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.orElse(null);
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @PutMapping("/update")
    public Company updateCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

}
