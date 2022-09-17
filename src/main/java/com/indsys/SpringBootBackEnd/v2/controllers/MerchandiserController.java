package com.indsys.SpringBootBackEnd.v2.controllers;

import com.indsys.SpringBootBackEnd.v2.models.Merchandiser;
import com.indsys.SpringBootBackEnd.v2.repositories.MerchandiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/merchandiser")
@CrossOrigin(origins = "*")
public class MerchandiserController {

    @Autowired
    MerchandiserRepository merchandiserRepository;

    @PostMapping("/create")
    public Merchandiser createMerchandiser(@RequestBody Merchandiser merchandiser){
        return merchandiserRepository.save(merchandiser);
    }

    @GetMapping("/id/{id}")
    public Merchandiser getById(@PathVariable("id") String id){
        Optional<Merchandiser> optionalMerchandiser = merchandiserRepository.findById(id);
        return optionalMerchandiser.orElse(null);
    }

    @GetMapping("/all")
    public List<Merchandiser> getAllMerchandisers(){
        return merchandiserRepository.findAll();
    }

    @GetMapping("/companyId/{companyId}")
    public List<Merchandiser> getByCompanyId(@PathVariable("companyId") String companyId){
        return merchandiserRepository.getBycompanyId(companyId);
    }

    @PutMapping("/update")
    public Merchandiser updateMerchandiser(@RequestBody Merchandiser merchandiser){
        return merchandiserRepository.save(merchandiser);
    }
}
