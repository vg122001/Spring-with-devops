package com.nagarro.Repo;

import com.nagarro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentUserRepo extends JpaRepository<Student,Long> {
   //Student findByRollNoAndName(Long rollNo, String name);
   List<Student> findByRollNoAndName(long rollNo, String name);

}

