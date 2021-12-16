package com.nisum.tech.controller;

import com.nisum.tech.application.service.UserService;
import com.nisum.tech.controller.model.UserRequest;
import com.nisum.tech.controller.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest body) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponse.of(userService.createUser(body.toDomain())));
    }
}
