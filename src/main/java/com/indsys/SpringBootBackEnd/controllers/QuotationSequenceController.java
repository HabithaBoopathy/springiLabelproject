package com.indsys.SpringBootBackEnd.controllers;

import com.indsys.SpringBootBackEnd.models.QuotationSequence;
import com.indsys.SpringBootBackEnd.repositories.QuotationSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/quotationsequence")
public class QuotationSequenceController {

    @Autowired
    QuotationSequenceRepository quotationSequenceRepository;

    //will gets called during initial project setup using POSTMAN to create
    //default sequence objects for all the 4 types
    @PostMapping(value="/reset/{resetCode}")
    public List<QuotationSequence> resetQuotation(@PathVariable(value="resetCode") String resetCode){
        if(resetCode.equals("$$Indsys-QuotationForm-reset$$")){
            List<QuotationSequence> quotationSequences = Arrays.asList(
                    new QuotationSequence("WOVEN", 1),
                    new QuotationSequence("TAG", 1),
                    new QuotationSequence("STICKER", 1),
                    new QuotationSequence("PRINTED", 1));
            return quotationSequenceRepository.saveAll(quotationSequences);
        }
        return null;
    }

   @GetMapping
    public List<QuotationSequence> getAll(){
        return quotationSequenceRepository.findAll();
    }

    @PutMapping(value = "/edit")
    public QuotationSequence editQuotationSequence(@RequestBody QuotationSequence quotationSequence){
        return quotationSequenceRepository.save(quotationSequence);
    }

    /*@DeleteMapping
    public void delete(){
        quotationSequenceRepository.deleteAll();
    }*/
}
