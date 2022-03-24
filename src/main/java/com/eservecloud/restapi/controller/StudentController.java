package com.eservecloud.restapi.controller;


import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.exception.ResourceNotFoundException;
import com.eservecloud.restapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //Build create student REST API
    @PostMapping("/saveStudentList")
    public ResponseEntity<String> saveBulkStudentTo(@RequestBody List<StudentTo> studentTo) {
        return new ResponseEntity<String>(studentService.saveBulkStudent(studentTo), HttpStatus.CREATED);
    }

    @GetMapping("/GetAllStudentsInfo")
    public List<StudentTo> getAllAddress() {
        return studentService.getAllStudentTo();
    }

   @GetMapping("/student/{id}")
    public ResponseEntity<List<StudentTo>> getStudentToByID(@PathVariable("id")Integer id )
    {
            return new ResponseEntity<List<StudentTo>>(studentService.getStudentToByID(id),HttpStatus.OK);
    }

    @GetMapping("/student/{email}/{usn}")
    public ResponseEntity<List<StudentTo>> getByIdAndUsn(@PathVariable("email")String email,@PathVariable("usn") String usn )
    {

        return new ResponseEntity<List<StudentTo>>(studentService.getByUsn(email,usn),HttpStatus.OK);

    }
    /* @GetMapping("/GetStudentByPhoneNumber/EmailId/{phoneNumber}/{emailId}")
    public StudentTo findStudentByPhoneNumberAndEmailId(@PathVariable(name="phoneNumber")Integer phoneNumber,@PathVariable(name = "emailId")String emailId)
     {
         return new ResponseEntity<StudentTo>(studentService.getStudentToByPhoneNumberAndEmailId(phoneNumber,emailId));
     }*/


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
