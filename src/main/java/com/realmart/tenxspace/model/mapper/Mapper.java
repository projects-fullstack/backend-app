package com.realmart.tenxspace.model.mapper;

import com.realmart.tenxspace.entity.User;
import com.realmart.tenxspace.model.dto.UserDto;

public class Mapper {

    public static UserDto covertUserToUserDto(User user){

        UserDto userDto  = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setFullName(user.getFullName());
        userDto.setPassword(user.getPassword());

        return userDto;

    }

    public static User covertUserDtotoUser(UserDto userDto){

        User user  = new User();
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());

        return user;

    }
}
