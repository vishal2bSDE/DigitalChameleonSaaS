package com.example.digitalchameleonsaas.controller;

import com.example.digitalchameleonsaas.dao.Country;
import com.example.digitalchameleonsaas.service.CountryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestParam String country) throws NotFoundException {
        return ResponseEntity.ok(countryService.addCountry(country));
    }

    @GetMapping("/get")
    public ResponseEntity<Country> getCountry(@RequestParam String country) throws NotFoundException {
        return ResponseEntity.ok(countryService.getCountryByName(country));
    }
}
