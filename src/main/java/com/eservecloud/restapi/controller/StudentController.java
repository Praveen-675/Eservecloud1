package com.eservecloud.restapi.controller;


import com.eservecloud.restapi.dto.StudentAddressTo;
import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.model.Student;
import com.eservecloud.restapi.service.StudentService;
import com.eservecloud.restapi.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;



    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    //Build create student REST API
   @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudentTo(@RequestBody StudentTo studentTo){
     return new ResponseEntity<String>(studentService.saveStudent(studentTo),HttpStatus.CREATED);
    }
/*@GetMapping()
     public StudentTo getAllAddress(){
    return  studentService.getAllStudentTo();
}*/
@GetMapping()
public List<Student> getAllStudentTo() {
    return studentService.getAllStudentTo();
}


   /* //Built get all student REST API
    @GetMapping()
    public List<Student> getAllStudents(){
        return  studentService.getAllStudent();
    }
    //Get all students by ID REST API
   @GetMapping("{id}")
    public ResponseEntity<Student> getStudentId( @PathVariable("id")Integer id)
    {
        return new ResponseEntity<Student>(studentService.getStudentByID(id),HttpStatus.OK);

    }
    //DTO mapping

    StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
   *//* @PostMapping("/")
    public ResponseEntity<StudentAddressTo> saveStudentAddressTo(@RequestBody StudentAddressTo studentAddressTo){
        return  new ResponseEntity<StudentAddressTo>(studentServiceImpl.saveStudentAddressTo(), HttpStatus.CREATED);
    }*//*
     @GetMapping("/Student_location")
   public List<StudentAddressTo> getAllStudentAddressTo(){
         StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
         return studentServiceImpl.getAllStudentAddress();
    }
*/



}
