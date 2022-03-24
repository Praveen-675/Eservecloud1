package com.eservecloud.restapi.service.impl;

import com.eservecloud.restapi.dto.AddressTo;
import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.exception.ResourceNotFoundException;
import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.model.Student;
import com.eservecloud.restapi.repository.StudentRepo;
import com.eservecloud.restapi.service.StudentService;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentRepo addressRepo;

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

    /*@Override
    public List<StudentTo> getStudentListByUsn(String usn) {
        List<StudentTo> studentInfoByUsn=studentRepo.getUsn(usn);

        return studentInfoByUsn;
    }*/

    @Override
    public List<StudentTo> getStudentToByID(Integer id) {
        Student studentById=studentRepo.getById(id);
        StudentTo studentsById=new StudentTo();
        studentsById.setName(studentById.getName());
        studentsById.setUsn(studentById.getUsn());
        studentsById.setAge(studentById.getAge());
        List<Address> address=studentById.getAddress();
        AddressTo addressById=new AddressTo();
        List<AddressTo>  addressList=new ArrayList<>();
        for (Address address1:address)
        {

            addressById.setAdd1(address1.getAdd1());
            addressById.setAdd2(address1.getAdd2());
            addressById.setPinCode(address1.getPinCode());
        }
        List<StudentTo> studentInfoById=new ArrayList<>();
        addressList.add(addressById);
        studentsById.setStudentAddressList(addressList);
        studentInfoById.add(studentsById);
        //studentInfoById.add(addressById);
        return studentInfoById;
    }

    @Override
    public List<StudentTo> getByIdAndUsn(Integer id, String usn) {
        Student studentById=studentRepo.getByIdAndUsn(id,usn);
       // Student studentById=studentRepo.getById(id);
        StudentTo studentsById=new StudentTo();

        if (studentById != null) {
            studentsById.setName(studentById.getName());
            studentsById.setUsn(studentById.getUsn());
            studentsById.setAge(studentById.getAge());
            List<Address> address=studentById.getAddress();
            AddressTo addressById=new AddressTo();
            List<AddressTo>  addressList=new ArrayList<>();
            for (Address address1:address)
            {

                addressById.setAdd1(address1.getAdd1());
                addressById.setAdd2(address1.getAdd2());
                addressById.setPinCode(address1.getPinCode());
            }
            List<StudentTo> studentInfoById=new ArrayList<>();
            addressList.add(addressById);
            studentsById.setStudentAddressList(addressList);
            studentInfoById.add(studentsById);
            //studentInfoById.add(addressById);
            return studentInfoById;
        } else {
            throw new ResourceNotFoundException("ID","id",);
        }


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




