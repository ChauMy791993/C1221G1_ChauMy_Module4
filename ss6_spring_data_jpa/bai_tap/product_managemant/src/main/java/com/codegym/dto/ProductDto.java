package com.codegym.dto;

import javax.validation.constraints.*;

public class ProductDto {

    private int id;

    @NotBlank(message = "name.notNull")
    @Size(min = 1,max = 800,message = "name.limitCharacter800")
    @Pattern(regexp = "^[\\w]+$",message ="name.mistype" )
    private String name;

    @NotBlank(message = "price.notNull")
    @PositiveOrZero(message ="price.mistype" )
    private double price;

    @NotBlank(message = "description.notNull")
    @Size(min = 1,max = 400,message = "description.limitCharacter400")
    @Pattern(regexp = "^[\\w]+$",message ="description.mistype" )
    private String description;

    @NotBlank(message = "manufacturer.notNull")
    @Size(min = 1,max = 600,message = "manufacturer.limitCharacter600")
    @Pattern(regexp = "^[\\w]+$",message ="manufacturer.mistype" )
    private String manufacturer;

    public ProductDto() {
    }

    public ProductDto(String name, double price, String description, String manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
