package com.indsys.SpringBootBackEnd.controllers.orderForms;

import com.indsys.SpringBootBackEnd.models.orderForms.Everything;
import com.indsys.SpringBootBackEnd.models.orderForms.PaginationInput;
import com.indsys.SpringBootBackEnd.service.orderForms.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/orders/pagination")
@CrossOrigin(origins = "*")
public class PaginationController {

    @Autowired
    PaginationService paginationService;

    @PostMapping
    public ResponseEntity<Page<Everything>> getOrders(@RequestBody PaginationInput paginationInput){
        return ResponseEntity.ok(paginationService.getOrders(paginationInput));
    }


}
