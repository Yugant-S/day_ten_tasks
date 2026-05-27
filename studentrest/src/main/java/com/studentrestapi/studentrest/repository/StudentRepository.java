package com.studentrestapi.studentrest.repository;

import com.studentrestapi.studentrest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByBranchIgnoreCase(String branch);
}