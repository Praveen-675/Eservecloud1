package com.eservecloud.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eservecloud.restapi.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
 Student getByUsn(String usn);
}
