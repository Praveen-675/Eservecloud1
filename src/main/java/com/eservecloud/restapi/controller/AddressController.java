package com.eservecloud.restapi.controller;

import com.eservecloud.restapi.model.Address;

import com.eservecloud.restapi.service.AddressService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService) {
        super();
        this.addressService = addressService;
    }
    //Build create student REST API
    @PostMapping("/post-address")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        return  new ResponseEntity<Address>(addressService.saveAddress(address), HttpStatus.CREATED);
    }

    //Built get all student REST API
    @GetMapping("/get-address")
    public List<Address> getAllAddress(){
        return  addressService.getAllAddress();
    }
    //Get all students by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<Address>(addressService.getAddressByID(id),HttpStatus.OK);

    }
}
