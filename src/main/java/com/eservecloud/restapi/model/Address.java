package com.eservecloud.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")// to make table as "Students"
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//@GeneratedValue it specifies generation strategies for the valve of primary keys
    private  int id;
    @Column(name ="address1", nullable=false)
    private String add1;
    @Column(name ="address2", nullable=false)
    private String add2;
    @Column(name ="pin_code", nullable=false)
    private int pinCode;



}
