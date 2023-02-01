package com.example.digitalchameleonsaas.controller;

import com.example.digitalchameleonsaas.dao.City;
import com.example.digitalchameleonsaas.service.CityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestParam String city, @RequestParam String country) throws NotFoundException {
        return ResponseEntity.ok(cityService.addCity(city, country));
    }

    @GetMapping("/get")
    public ResponseEntity<City> getCity(@RequestParam String city) throws NotFoundException {
        return ResponseEntity.ok(cityService.getCityByName(city));
    }
}
