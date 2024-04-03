package com.nagarro.service;

import com.nagarro.Repo.StudentUserRepo;
import com.nagarro.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentUserRepo studentUserRepo;

    @Autowired
    public StudentService(StudentUserRepo studentUserRepo) {
        this.studentUserRepo = studentUserRepo;
    }

    public List<Student> getStudentsByRollNoAndName(long rollNo, String name) {
        return studentUserRepo.findByRollNoAndName(rollNo, name);
    }
}




