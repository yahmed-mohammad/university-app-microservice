package com.example.service;

import com.example.entity.Address;
import com.example.model.AddressRequest;
import com.example.model.AddressResponse;
import com.example.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getAddressById(long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        Address address= null;
        if(addressOptional.isPresent()) {
            address = addressOptional.get();
        }
        return new AddressResponse(address);
    }
}
