package com.realmart.tenxspace.service;

import com.realmart.tenxspace.model.LoginResponse;
import com.realmart.tenxspace.model.dto.LoginDto;
import com.realmart.tenxspace.model.dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userReq);
    public LoginResponse loginUser(LoginDto loginDto) ;
}
