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
    public ResponseEntity<String> saveStudentTo(@RequestBody StudentTo studentTo) {
        return new ResponseEntity<String>(studentService.saveStudent(studentTo), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<StudentTo> getAllAddress() {
        return studentService.getAllStudentTo();
    }
    @GetMapping("{id}")
    public ResponseEntity<StudentTo> getStudentId( @PathVariable("id")Integer id)
    {

        return new ResponseEntity<StudentTo>(studentService.getStudentToByID(id),HttpStatus.OK);

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
    */
}
