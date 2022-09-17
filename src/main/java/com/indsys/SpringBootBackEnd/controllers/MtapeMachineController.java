package com.indsys.SpringBootBackEnd.controllers;

import com.indsys.SpringBootBackEnd.models.MtapeMachine;
import com.indsys.SpringBootBackEnd.repositories.MtapeMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/master/tapeMachine")
@CrossOrigin(origins = "*")
public class MtapeMachineController {

    @Autowired
    MtapeMachineRepository mtapeMachineRepository;

    @GetMapping("/all")
    public List<MtapeMachine> getAllMachines(){
        return mtapeMachineRepository.findAll();
    }

    @PostMapping("/create")
    public MtapeMachine createMachine(@RequestBody MtapeMachine mtapeMachine){
        return mtapeMachineRepository.insert(mtapeMachine);
    }

    @PutMapping("/update")
    public MtapeMachine updateMachine(@RequestBody MtapeMachine mtapeMachine){
        return mtapeMachineRepository.save(mtapeMachine);
    }

    @GetMapping("/id/{id}")
    public MtapeMachine getMachineById(@PathVariable("id") String id){
        return mtapeMachineRepository.findById(id).orElse(null);
    }
}
