package com.cadastro_usuario.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro_usuario.business.UserService;
import com.cadastro_usuario.infrastructure.entity.User;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        List<User> users = userService.createUser(user);
        return ResponseEntity.ok(users);
    }
    
    @GetMapping
    public ResponseEntity<User> readUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
    
    @PutMapping
    public ResponseEntity<List<User>> updateUserById(@RequestParam Integer id, @RequestBody User user) {
        List<User> users = userService.updateUserById(id, user);
        return ResponseEntity.ok(users);
    }
    

    @DeleteMapping
    public ResponseEntity<List<User>> deleteUserByEmail(@RequestParam String email) {
        List<User> users = userService.deleteUserByEmail(email);
        return ResponseEntity.ok(users);
    }
}