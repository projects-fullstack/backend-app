package com.realmart.tenxspace.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @Email
    @NotNull(message = "please enter your email address")
    private String email;
    @Size(min = 8, max =12)
    @NotNull(message = "please enter your password" )
    private String password;
    private String role;
    @NotNull(message = "please enter your fullname")
    private String fullName;


}
