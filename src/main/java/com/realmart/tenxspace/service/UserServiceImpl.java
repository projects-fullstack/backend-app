package com.realmart.tenxspace.service;

import com.realmart.tenxspace.dao.UserDao;
import com.realmart.tenxspace.entity.User;
import com.realmart.tenxspace.exceptions.UserAlreadyExists;
import com.realmart.tenxspace.model.LoginResponse;
import com.realmart.tenxspace.model.dto.LoginDto;
import com.realmart.tenxspace.model.dto.UserDto;
import com.realmart.tenxspace.model.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {



    @Autowired
    UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserDto userDto) {

        User userToSave = Mapper.covertUserDtotoUser(userDto);
        boolean flag= userDao.findByEmail(userDto.getEmail()).isPresent();
        if(flag){
//            throw new UserAlreadyExists(USER_EXISTS);
        }

        userToSave.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return Mapper.covertUserToUserDto(userDao.save(userToSave));

    }

    public LoginResponse loginUser(LoginDto loginDto) {

        Optional<User> user = userDao.findByEmail(loginDto.getEmail());
        if(user.isPresent()){
            String encodedPswrd = user.get().getPassword();
            String pswrd = loginDto.getPassword();
            boolean isCrctPswrd = passwordEncoder.matches(pswrd,encodedPswrd);
            if(isCrctPswrd){
                Optional<User> userWithIdPswrd = userDao.findByEmailAndPswrd(loginDto.getEmail(), encodedPswrd);
                if (userWithIdPswrd.isPresent()){
                    return  new LoginResponse("Login Successfull..!", true);
                }
                return new LoginResponse("Login Failed...!", false);
            }else {
                return new LoginResponse("Password does not match", false);
            }

        }else{
            return new LoginResponse("Email does not exists...!",false);
        }
    }

}
