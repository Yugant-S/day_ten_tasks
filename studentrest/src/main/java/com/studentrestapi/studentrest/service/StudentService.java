package com.studentrestapi.studentrest.service;

import com.studentrestapi.studentrest.entity.Student;
import com.studentrestapi.studentrest.exception.ResourceNotFoundException;
import com.studentrestapi.studentrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student cannot be deleted. Id not found: " + id));
        studentRepository.delete(student);
    }

    public List<Student> getStudentsByBranch(String branch) {
        return studentRepository.findByBranchIgnoreCase(branch);
    }
}