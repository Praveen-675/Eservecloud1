package com.eservecloud.restapi.service;

import com.eservecloud.restapi.dto.StudentTo;
import com.eservecloud.restapi.model.Student;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentTo studentTo);
    List<Student>  getAllStudentTo();
   // Integer getStudentToByID(Integer id);
}
