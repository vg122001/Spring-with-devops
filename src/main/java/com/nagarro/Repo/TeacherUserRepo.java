package com.nagarro.Repo;

import com.nagarro.model.TeacherUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherUserRepo extends JpaRepository<TeacherUser,String> {

    TeacherUser findByUsername(String username);
}
