package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class UserDto implements Validator {
    private Integer id;

    @Pattern(regexp = "^[A-za-z]{5,45}$",message = "min 5 and max character 45")
    private String firstName;

    @Pattern(regexp = "^[A-za-z]{5,45}$",message = "min 5 and max character 45")
    private String lastName;
    @Pattern(regexp = "^0\\d{9}$",message = "Invalid phone number")
    private String phone;

    private String age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
