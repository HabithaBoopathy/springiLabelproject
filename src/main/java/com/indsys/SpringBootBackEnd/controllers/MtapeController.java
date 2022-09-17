package com.indsys.SpringBootBackEnd.controllers;

import com.indsys.SpringBootBackEnd.models.Mtape;
import com.indsys.SpringBootBackEnd.repositories.MtapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/master/tape")
@CrossOrigin(origins = "*")
public class MtapeController {

    @Autowired
    MtapeRepository mtapeRepository;

    @GetMapping("/all")
    public List<Mtape> getAllTapes(){
      return mtapeRepository.findAll();
    }

    @PostMapping("/create")
    public Mtape createTape(@RequestBody Mtape mtape){
        return mtapeRepository.insert(mtape);
    }

    @PutMapping("/update")
    public Mtape updateTape(@RequestBody Mtape mtape){
        return mtapeRepository.save(mtape);
    }

    @GetMapping("/id/{id}")
    public Mtape getTapeById(@PathVariable("id") String id){
        return mtapeRepository.findById(id).orElse(null);
    }
}
