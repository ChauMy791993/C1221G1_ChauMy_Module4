package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UsersDto implements Validator {
    private Integer id;
    @NotBlank(message = "First name not null")
    @Pattern(regexp = "^[A-za-z]{5,45}$", message = "min 5 and max character 45")
    private String firstName;


    @NotBlank(message = "Last name not null")
    @Pattern(regexp = "^[A-za-z]{5,45}$", message = "min 5 and max character 45")
    private String lastName;

    @Pattern(regexp = "^0\\d{9}$", message = "Invalid phone number")
    private String phone;

    private String age;
    private String email;

    public UsersDto() {
    }

    public UsersDto(String firstName, String lastName, String phone, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsersDto userDto = (UsersDto) target;
        try {
            if (Integer.parseInt(userDto.getAge()) <= 18) {
                errors.rejectValue("age", "age.forbidden", "error default");
            }
        } catch (NumberFormatException numberFormatException) {
            errors.rejectValue("age", "age.format", "error default");
        }
        if (!userDto.getEmail().matches("^[\\w]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email.forbidden", "error default");
        }
    }
}

