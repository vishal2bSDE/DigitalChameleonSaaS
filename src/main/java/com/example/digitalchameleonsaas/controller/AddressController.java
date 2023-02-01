package com.example.digitalchameleonsaas.controller;

import java.util.List;
import com.example.digitalchameleonsaas.dao.Address;
import com.example.digitalchameleonsaas.service.AddressService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestParam String address, @RequestParam String city) throws NotFoundException {
        return ResponseEntity.ok(addressService.addAddress(city, address));
    }

    @GetMapping("/get")
    public ResponseEntity<Address> getAddress(@RequestParam String address) throws NotFoundException {
        return ResponseEntity.ok(addressService.getAddressByName(address));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAllAddress() throws NotFoundException {
        return ResponseEntity.ok(addressService.getAllAddress());
    }
}
