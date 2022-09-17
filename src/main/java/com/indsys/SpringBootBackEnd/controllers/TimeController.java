package com.indsys.SpringBootBackEnd.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@CrossOrigin
@RestController
@RequestMapping("/api/time/")
public class TimeController {

    @GetMapping("UTCDateTime")
    public String getCurrentDate(){
        return Instant.now().toString();
    }
}
