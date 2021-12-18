package com.nisum.tech.controller;

import com.nisum.tech.application.service.UserService;
import com.nisum.tech.config.exception.EmailDupedException;
import com.nisum.tech.config.exception.ErrorHandler;
import com.nisum.tech.config.exception.PasswordFormatException;
import com.nisum.tech.controller.model.UserRequest;
import com.nisum.tech.controller.model.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "Create an user", response = UserResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully retrieves a users"),
            @ApiResponse(code = 400, message = "Return an error because business logic", response = ErrorHandler.Response.class)
    })
    public ResponseEntity<UserResponse> create(@RequestBody @Validated UserRequest body) throws EmailDupedException, PasswordFormatException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponse.of(userService.createUser(body.toDomain())));
    }

}
