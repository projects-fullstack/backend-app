package com.realmart.tenxspace.controller;


import com.realmart.tenxspace.model.LoginResponse;
import com.realmart.tenxspace.model.dto.LoginDto;
import com.realmart.tenxspace.model.dto.UserDto;
import com.realmart.tenxspace.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.realmart.tenxspace.constants.TenxsapceConstants.SAVE_SUCCESS;

@RestController
@Validated
@RequestMapping("/tenxspace")
public class TenxspaceController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto){

        UserDto res = userService.registerUser(userDto);
        return new ResponseEntity<>(SAVE_SUCCESS, HttpStatus.CREATED);


    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto){

        LoginResponse loginResponse = userService.loginUser(loginDto);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);

    }


}
