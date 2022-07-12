package com.example.kt_md4.controller;

import com.example.kt_md4.model.City;
import com.example.kt_md4.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityServiceImpl cityService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }
}
