package com.example.springsecurity101.controller;


import com.example.springsecurity101.model.ApiResponse;
import com.example.springsecurity101.model.Users;
import com.example.springsecurity101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid Users user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("New User added", 200));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser() {
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back", 200));
    }

    @GetMapping("/user/me")
    public ResponseEntity<?> getUser(Principal principal) {
        return ResponseEntity.status(200).body(new ApiResponse(principal.getName(), 200));
    }

    @GetMapping("/user")
    public ResponseEntity<?> user() {
        return ResponseEntity.status(200).body(new ApiResponse("Hello User", 200));
    }

}
