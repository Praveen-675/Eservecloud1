package com.eservecloud.restapi.service.impl;

import com.eservecloud.restapi.dto.AddressTo;
import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.model.Student;
import com.eservecloud.restapi.repository.StudentRepo;
import com.eservecloud.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public StudentServiceImpl() {
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
    public String saveBulkStudent(List<StudentTo> studentTo) {
        List<Student> studentInfo = new ArrayList<>();
        for (StudentTo studentTos : studentTo) {
            Student student = new Student();
            student.setName(studentTos.getName());
            student.setUsn(studentTos.getUsn());
            student.setAge(studentTos.getAge());

            // Get AddressTo from StudentTo
            List<Address> addressList = new ArrayList<>();
            List<AddressTo> addressToList = studentTos.getStudentAddressList();
            for (AddressTo addressTo : addressToList) {
                Address address = new Address();
                address.setAdd1(addressTo.getAdd1());
                address.setAdd2(addressTo.getAdd2());
                address.setPinCode(addressTo.getPinCode());
                addressList.add(address);
            }
            student.setAddress(addressList);
            studentInfo.add(student);
        }
            // save Student
            List<Student> result = studentRepo.saveAll(studentInfo);
            if (result != null) {
                System.out.println(result);
                return "Student saved Successfully";
            } else {
                throw new RuntimeException("Student not saved");
            }

    }
    @Override
    public List<StudentTo> getAllStudentTo() {
      /*  List<Student> student = studentRepo.findAll();
        //Student To StudentTo conversion
        List<StudentTo> variable = (List<StudentTo>) (List<?>) student;*/
        List<Student> studentList=studentRepo.findAll();
        List<StudentTo> studentToList = new ArrayList<>();
        for (Student student : studentList)
        {
            StudentTo studentTo = new StudentTo();
            studentTo.setName(student.getName());
            studentTo.setAge(student.getAge());
            studentTo.setUsn(student.getUsn());
            // Getting Address List
            List<Address> studentAddressList = student.getAddress();
            List<AddressTo> addressToList = new ArrayList<>();
            for (Address address : studentAddressList)
            {
                AddressTo addressTo = new AddressTo();
                addressTo.setAdd1(address.getAdd1());
                addressTo.setAdd2(address.getAdd2());
                addressTo.setPinCode(address.getPinCode());
                addressToList.add(addressTo);
            }
            studentTo.setStudentAddressList(addressToList);
            studentToList.add(studentTo);
        }
        return studentToList;
    }

   /* @Override
    public String saveBulkStudent(List<StudentTo> studentTo) {
       List<Student> studentList=(List<Student>) (List<?>) studentTo;

        List<Student> result = studentRepo.saveAll(studentList);
        if(result != null)
        {
            System.out.println(result);
            return "Students List saved Successfully";
        }
        else {
            throw new RuntimeException("Student not saved");
        }


    }*/



   /* @Override
    public Integer getStudentToByID(Integer id) {
       Student student= Mapper.map()
        return null;
    }*/
}




