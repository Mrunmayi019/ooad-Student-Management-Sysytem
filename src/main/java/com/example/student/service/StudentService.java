package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {

        if(repository.existsByEmail(student.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        return repository.save(student);
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
}