package com.codegym.dto;

import com.codegym.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerDto implements Validator {
    private Integer customerId;

    @NotBlank(message = "{code.notnull}")
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "{code.mistype}")
    private String customerCode;

    @NotBlank(message = "{name.notnull}")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}*)*$", message = "{name.mistype}")
    private String customerName;


    private String customerDateOfBirth;


    private Integer customerGender;
    @NotBlank(message = "{idCard.notnull}")
    @Pattern(regexp = "^\\d{9}|\\d{12}", message = "{idCard.mistype}")
    private String customerIdCard;
    @NotBlank(message = "{phone.notnull}")
    @Pattern(regexp = "^(090|091|\\(84\\)90|\\(84\\)91)\\d{7}$", message = "{phone.mistype}")
    private String customerPhone;
    @NotBlank(message = "{email.notnull}")
    @Pattern(regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+)(\\.\\w{2,3})?$", message = "{email.mistype}")
    private String customerEmail;

    private String customerAddress;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(String customerName, String customerDateOfBirth, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerName = customerName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate now = LocalDate.now();
        LocalDate eighteenYear = now.minusYears(18);
        LocalDate hundredYear = now.minusYears(100);
        if ("".equals(customerDto.customerDateOfBirth)) {
            errors.rejectValue("customerDateOfBirth", "birthday.notnull", "error default!");
        } else if (LocalDate.parse(customerDto.customerDateOfBirth).compareTo(eighteenYear) > 0 ||
                LocalDate.parse(customerDto.customerDateOfBirth).compareTo(hundredYear) < 0) {
            errors.rejectValue("customerDateOfBirth", "birthday.mistype", "error default!");
        }
    }
}
