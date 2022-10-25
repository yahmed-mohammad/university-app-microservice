package com.example.controller;

import com.example.entity.Address;
import com.example.model.AddressRequest;
import com.example.model.AddressResponse;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest request) {
         return addressService.createAddress(request);
    }

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable long id) {
        return addressService.getAddressById(id);
    }
}
