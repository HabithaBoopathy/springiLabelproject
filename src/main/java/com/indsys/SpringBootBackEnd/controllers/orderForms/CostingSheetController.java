package com.indsys.SpringBootBackEnd.controllers.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.CostingSheet;
import com.indsys.SpringBootBackEnd.repositories.orderForms.CostingSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/costingSheet/")
@CrossOrigin(origins = "*")
public class CostingSheetController {

    @Autowired
    CostingSheetRepository costingSheetRepository;

    @PostMapping("add")
    public CostingSheet add(@RequestBody CostingSheet costingSheet){
        return costingSheetRepository.save(costingSheet);
    }

    @GetMapping("get/{orderId}")
    public CostingSheet getById(@PathVariable("orderId") String orderId){
        return costingSheetRepository.findByOrderId(orderId);
    }

    @PutMapping("edit")
    public CostingSheet edit(@RequestBody CostingSheet costingSheet){
        return costingSheetRepository.save(costingSheet);
    }
}
