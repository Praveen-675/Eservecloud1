package com.eservecloud.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data // it avoids getter,setter method,to-string,equals-method,hash code-methode
@Entity // it treaties this class as a jpa entity
@Table(name="Students")// to make table as "Students"

public class Student {
    @Id  // used to mention this is a primary-key
    @GeneratedValue(strategy= GenerationType.IDENTITY)//@GeneratedValue it specifies generation strategies for the valve of primary keys
    private  int id;
    @Column(name ="Student_Name", nullable=false, unique = true)
    private String name;
    @Column(name = "usn")
    private String usn;
    @Column(name = "age")
    private int age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pc_fid",referencedColumnName ="id")
    List<Address> address = new ArrayList<>();


}
