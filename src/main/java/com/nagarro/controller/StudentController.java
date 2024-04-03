package com.nagarro.controller;

import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.Student;
import com.nagarro.Repo.StudentUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentUserRepo studentRepository;

    //get all students rest API
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //create student rest api
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
    //update student restApi
    @PutMapping("/students/{rollNo}")
    public ResponseEntity<Student> updateResult(@PathVariable Long rollNo,@RequestBody Student studentDetails){
         Student student=studentRepository.findById(rollNo)
                 .orElseThrow(()->new ResourceNotFoundException("Student not exist with rollNo:"+rollNo));

         student.setName(studentDetails.getName());
         student.setDob(studentDetails.getDob());
         student.setScore(studentDetails.getScore());

         Student updatedStudent= studentRepository.save(student);
         return ResponseEntity.ok(updatedStudent);

    }

    //delete result rest api
    @DeleteMapping("/students/{rollNo}")
    public ResponseEntity<Map<String,Boolean> >deleteResult(@PathVariable Long rollNo){
        Student student=studentRepository.findById(rollNo)
                .orElseThrow(()->new ResourceNotFoundException("Student not exist with rollNo:"+rollNo));

        studentRepository.delete(student);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
