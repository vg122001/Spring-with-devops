package com.nagarro.controller;
import com.nagarro.Repo.TeacherUserRepo;
import com.nagarro.model.TeacherUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class TeacherUserController {
    @Autowired
    private TeacherUserRepo repo;
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody TeacherUser userData){
        System.out.println(userData);
        TeacherUser user=repo.findByUsername(userData.getUsername());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);

        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
