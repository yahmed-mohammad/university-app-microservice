package com.example.feignclient;

import com.example.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address-service", path = "/api/address")
public interface AddressClient {

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable long id);
}
