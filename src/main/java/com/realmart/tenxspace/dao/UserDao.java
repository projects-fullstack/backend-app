package com.realmart.tenxspace.dao;

import com.realmart.tenxspace.entity.User;
import com.realmart.tenxspace.model.dto.UserDto;

import java.util.Optional;

public interface UserDao {
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPswrd(String email, String encodedPswrd);
}
