package com.eservecloud.restapi.service;

import com.eservecloud.restapi.dto.StudentTo;

import java.util.List;

public interface StudentService {
    String saveBulkStudent(List<StudentTo> studentTo);
    List<StudentTo> getAllStudentTo();
    //List<StudentTo> getStudentListByUsn(String usn);
   List<StudentTo> getStudentToByID(Integer id);
   List<StudentTo> getByUsn(String email, String usn);
}
