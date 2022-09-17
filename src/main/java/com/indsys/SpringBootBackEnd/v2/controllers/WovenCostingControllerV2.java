package com.indsys.SpringBootBackEnd.v2.controllers;

import com.indsys.SpringBootBackEnd.v2.models.WovenCostingV2;
import com.indsys.SpringBootBackEnd.v2.repositories.WovenCostingRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/master/costing/v2/woven")
@CrossOrigin(origins = "*")
public class WovenCostingControllerV2 {

    @Autowired
    WovenCostingRepositoryV2 wovenCostingRepositoryV2;

    @PostMapping("/create")
    public WovenCostingV2 createWovenCosting(@RequestParam WovenCostingV2 wovenCostingV2){
        return wovenCostingRepositoryV2.save(wovenCostingV2);
    }

    @PutMapping("/update")
    public WovenCostingV2 editWovenCosting(@RequestBody WovenCostingV2 wovenCostingV2){
        return wovenCostingRepositoryV2.save(wovenCostingV2);
    }

    @GetMapping("/id/{id}")
    public WovenCostingV2 getWovenCostingById(@PathVariable("id") String id){
        Optional<WovenCostingV2> optionalWovenCosting = wovenCostingRepositoryV2.findById(id);
        return optionalWovenCosting.orElse(null);
    }

    @GetMapping("/orderId/{id}")
    public WovenCostingV2 getWovenCostingByOrderId(@PathVariable("id") String id){
        return wovenCostingRepositoryV2.getByOrderId(id);
    }
}
