package com.example.kt_md4.controller;

import com.example.kt_md4.model.City;
import com.example.kt_md4.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
    @PostMapping()
    public ResponseEntity<Iterable<City>> add(@Valid @RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> findById(@PathVariable long id) {
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> edit(@PathVariable long id, @RequestBody City city) {
        Optional<City> product1 = cityService.findById(id);
        if (!product1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(product1.get().getId());
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable long id){
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
