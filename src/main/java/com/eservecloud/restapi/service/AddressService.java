package com.eservecloud.restapi.service;

import com.eservecloud.restapi.model.Address;


import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);
    List<Address> getAllAddress();
    Address getAddressByID(Integer id);
}
