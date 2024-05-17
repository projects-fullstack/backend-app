package com.realmart.tenxspace.dao;

import com.realmart.tenxspace.entity.User;
import com.realmart.tenxspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepo;
    @Override
    public User save(User user) {
        User userSaved = userRepo.save(user);
        return userSaved;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<User> findByEmailAndPswrd(String email, String encodedPswrd) {
        return userRepo.findOneByEmailAndPassword(email, encodedPswrd);
    }

}


