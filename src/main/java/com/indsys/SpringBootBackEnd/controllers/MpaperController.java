package com.indsys.SpringBootBackEnd.controllers;

import com.indsys.SpringBootBackEnd.models.Mpaper;
import com.indsys.SpringBootBackEnd.repositories.MpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/master/paper")
@CrossOrigin(origins = "*")
public class MpaperController {

    @Autowired
    MpaperRepository mpaperRepository;

    @GetMapping("/all")
    public List<Mpaper> getAllPapers(){
        return mpaperRepository.findAll();
    }

    @PostMapping("/create")
    public Mpaper createPaper(@RequestBody Mpaper mpaper){
        return mpaperRepository.insert(mpaper);
    }

    @PutMapping("/update")
    public Mpaper updatePaper(@RequestBody Mpaper mpaper){
        return mpaperRepository.save(mpaper);
    }

    @GetMapping("/id/{id}")
    public Mpaper getPaperById(@PathVariable("id") String id){
        return mpaperRepository.findById(id).orElse(null);
    }

}
