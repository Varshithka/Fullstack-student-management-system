package com.studentjpa.controller;


//import com.studentjpa.entity.student;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//    @RequestMapping("/api/students")
//    @CrossOrigin(origins = "http://localhost:5174")
//    public class MyController {
//
//        @PostMapping
//        public ResponseEntity<String> saveStudent(@RequestBody student student) {
//            System.out.println(student.getName());
//            return ResponseEntity.ok("Student saved");
//        }
//    }
//

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentjpa.entity.student;
import com.studentjpa.Repository.StudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173")
public class MyController {

    private final StudentRepository studentRepository;

    public MyController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // POST → save student (name, email, age)
    @PostMapping
    public student addStudent(@RequestBody student student) {
        return studentRepository.save(student);
    }

    // GET → get all students
    @GetMapping
    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }
}