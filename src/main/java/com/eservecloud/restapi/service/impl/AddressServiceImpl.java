package com.eservecloud.restapi.service.impl;

import com.eservecloud.restapi.exception.ResourceNotFoundException;
import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.service.AddressService;
import com.eservecloud.restapi.repository.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepo addressRepo;

    /*public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }
*/
    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }
    @Override
    public Address getAddressByID(Integer id) {
        Optional<Address> address=addressRepo.findById(id);
        if(address.isPresent())
        {
            return address.get();
        }
        else {
            throw new ResourceNotFoundException("Address","Id",id);
        }
    }
}
