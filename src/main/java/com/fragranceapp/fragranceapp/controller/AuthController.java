package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.UserDTO;
import com.fragranceapp.fragranceapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> signup(@RequestBody UserDTO newUser) {
        userService.createRegularUser(newUser);

        return new ResponseEntity<>("Your user account has been created", HttpStatus.CREATED);
    }
}
