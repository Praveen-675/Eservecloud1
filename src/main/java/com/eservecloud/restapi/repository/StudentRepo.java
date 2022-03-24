package com.eservecloud.restapi.repository;

import com.eservecloud.restapi.dto.StudentTo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eservecloud.restapi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
 Student getByIdAndUsn(Integer id,String usn);
}
