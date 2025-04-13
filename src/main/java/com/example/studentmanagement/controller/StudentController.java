package com.example.studentmanagement.controller;


import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody @Valid Student student){
        return repository.save(student);
    }

    @PutMapping("/{Sid}")
    public Student updateStudent(@PathVariable int Sid, @RequestBody @Valid Student studentDetails){
            Student student = repository.findById(Sid).orElseThrow();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setCourse(studentDetails.getCourse());
            return repository.save(student);
    }

    @DeleteMapping("/{Sid}")
    public void deleteStudent(@PathVariable int Sid){
        repository.deleteById(Sid);
    }

    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/{Sid}")
    public Student getStudentById(@PathVariable int Sid){
        return repository.findById(Sid).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
