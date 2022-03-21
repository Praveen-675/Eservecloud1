package com.eservecloud.restapi.service.impl;

import com.eservecloud.restapi.dto.StudentAddressTo;
import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.exception.ResourceNotFoundException;
import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.model.Student;
import com.eservecloud.restapi.repository.StudentRepo;
import com.eservecloud.restapi.service.StudentService;
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
    //Dto mapping
    /*public StudentAddressTo saveStdentAddressTo(StudentAddressTo studentAddressTo){
        return studentRepo.save(studentAddressTo);
    }*/

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
    public List<Student> getAllStudentTo() {
        return studentRepo.findAll();
    }



   /* @Override
    public List<StudentTo> getAllStudentTo() {
        Student student=new Student();
        StudentTo studentTo=new StudentTo();
       List<StudentTo> result=new Student()
            result.get(1);
            studentTo.setName(student.getName());
            studentTo.setUsn(student.getUsn());
            studentTo.setAge(student.getAge());

        return studentTo;
    }*/
/*
    public Integer getStudentToByID(Integer id) {
        if(getAllStudentTo()!=null)
        {
            return getAllStudentTo();
        }
        else {
            throw new ResourceNotFoundException("Student","Id",id);
        }*/

       /* StudentTo studentto=new StudentTo();
        studentto.setName(studentTo.getName());
        studentto.setAge(studentTo.getAge());
        studentto.setUsn(studentTo.getUsn());
        studentto.setStudentAddressList(studentTo.getStudentAddressList());
        return studentTo;*/


    }


  /*  @Override
    public List<StudentTo> getAllStudentTo() {
        return null;
    }

    @Override
    public StudentTo getStudentToByID(Integer id) {
        return null;
    }
   public List<StudentAddressTo> getAllStudentAddress(){
        return studentRepo.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
    public StudentAddressTo convertEntityToDto(Student student)
    {
        StudentTo studentto=new StudentTo();
        studentto.setId(student.getId());
        studentto.setName(student.getName());
       studentto.setStudentAddressTo(student.getADdressto);
       *//* studentto.setAdd1(student.getAddress().getAdd1());
        studentto.setAdd1(student.getAddress().getAdd2());
        studentto.setPinCode(student.getAddress().getPinCode());*//*
        return studentto;
    }

*/

