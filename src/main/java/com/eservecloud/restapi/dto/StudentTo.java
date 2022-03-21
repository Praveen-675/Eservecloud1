package com.eservecloud.restapi.dto;

import lombok.Data;

import java.util.List;
@Data
public class StudentTo {
    private Integer id;
    private  String usn;
    private String name;
    private int age;
    private List<StudentAddressTo> studentAddressList;
}
