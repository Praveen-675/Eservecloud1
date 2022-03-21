package com.eservecloud.restapi.service.impl;

import com.eservecloud.restapi.dto.StudentAddressTo;
import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.exception.ResourceNotFoundException;
import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.model.Student;
import com.eservecloud.restapi.repository.StudentRepo;
import com.eservecloud.restapi.service.StudentService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
   private StudentRepo studentRepo;

    public StudentServiceImpl()
    {
        this.studentRepo = studentRepo;
    }


//Curd repository
   /* @Override
    public Student saveStudent(StudentTo studentTo) {
        return studentRepo.save(studentTo);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentByID(Integer id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isPresent())
        {
            return student.get();
        }
        else {
            throw new ResourceNotFoundException("Student","Id",id);
        }
    }*/
   //DTO Transactions
   @Override
   public String saveStudent(StudentTo studentTo) {
       Student student = new Student();
       student.setName(studentTo.getName());
       student.setUsn(studentTo.getUsn());
       student.setAge(studentTo.getAge());

       // Get AddressTo from StudentTo
       List<Address> addressList = new ArrayList<>();
       List<StudentAddressTo> studentAddressToList = studentTo.getStudentAddressList();
       for (StudentAddressTo studentAddressTo:studentAddressToList) {
           Address address = new Address();
           address.setAdd1(studentAddressTo.getAdd1());
           address.setAdd2(studentAddressTo.getAdd2());
           address.setPinCode(studentAddressTo.getPinCode());
           addressList.add(address);
       }
       student.setAddress(addressList);
       // save Student
       Student result = studentRepo.save(student);
       if(result != null)
       {
           System.out.println(result);
           return "Student saved Successfully";
       }
       else {
           throw new RuntimeException("Student not saved");
       }
   }

    @Override
    public List<StudentTo> getAllStudentTo() {
        List<Student> student = studentRepo.findAll();
        List<StudentTo> result = new ArrayList<>();
        //Student To StudentTo conversion
        List<StudentTo> variable = (List<StudentTo>) (List<?>) student;
        return variable;
    }

    @Override
    public Integer getStudentToByID(Integer id) {
       Student student= Mapper.map()
        return null;
    }
}



