package com.nagarro.controller;

import com.nagarro.model.Student;
import com.nagarro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studentLogin")
@CrossOrigin(origins = "*")
public class StudentLoginController {
    private final StudentService studentService;

    @Autowired
    public StudentLoginController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudentsByRollNoAndName(
            @RequestParam("rollNo") long rollNo,
            @RequestParam("name") String name
    ) {
        List<Student> students = studentService.getStudentsByRollNoAndName(rollNo, name);
        return ResponseEntity.ok(students);
    }
}

