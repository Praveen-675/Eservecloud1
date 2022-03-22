package com.eservecloud.restapi.dto;

import lombok.Data;

import java.util.List;
@Data
public class StudentTo {
    //private int id;
    private  String usn;
    private String name;
    private int age;
    private List<AddressTo> studentAddressList;
}
