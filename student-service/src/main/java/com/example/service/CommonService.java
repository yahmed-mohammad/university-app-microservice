package com.example.service;

import com.example.feignclient.AddressClient;
import com.example.model.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);

    long count = 1;

    @Autowired
    AddressClient addressClient;

    @CircuitBreaker(name="addressService", fallbackMethod = "fallbackForGetAddressById")
    public AddressResponse getAddressById(long addressId) {
        logger.info("count= "+ count);
        count++;
        AddressResponse addressResponse = addressClient.getAddressById(addressId);

        return addressResponse;
    }

    /**
     * Dummy response
     * @param addressId
     * @return
     */
    public AddressResponse fallbackForGetAddressById(long addressId, Throwable throwable){
        logger.error("Error= "+ throwable);
        return new AddressResponse();
    }
}
