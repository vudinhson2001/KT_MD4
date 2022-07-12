package com.example.kt_md4.controller;

import com.example.kt_md4.model.Country;
import com.example.kt_md4.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryServiceImpl countryService;
    @GetMapping
    public ResponseEntity<Iterable<Country>> findAll(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }
}
