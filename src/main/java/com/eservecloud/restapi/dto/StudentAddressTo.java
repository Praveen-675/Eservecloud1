package com.eservecloud.restapi.dto;

import com.eservecloud.restapi.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class StudentAddressTo {
    private String add1;
    private String add2;
    private int pinCode;


}
