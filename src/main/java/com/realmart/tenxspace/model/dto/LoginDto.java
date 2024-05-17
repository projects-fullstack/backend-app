package com.realmart.tenxspace.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class LoginDto {

    @Email
    @NonNull
    private String email;
    @Size(min = 8, max =12)
    @NonNull
    private String password;



}
