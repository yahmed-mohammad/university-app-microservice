package com.example.feignclient;

import com.example.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway")
public interface AddressClient {

    @GetMapping("/address-service/api/address/{id}")
    public AddressResponse getAddressById(@PathVariable long id);
}
