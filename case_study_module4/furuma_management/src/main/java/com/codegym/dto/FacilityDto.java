package com.codegym.dto;

import com.codegym.model.FacilityType;
import com.codegym.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class FacilityDto implements Validator {
    private Integer facilityId;

    @NotBlank(message = "{code.notnull}")
    @Pattern(regexp = "^(DV-)\\d{4}$", message = "{facilityCode.mistype}")
    private String facilityCode;

    private String facilityName;
    @NotBlank(message = "{area.notnull}")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "{area.mistype}")
    private String facilityArea;


    @NotBlank(message = "{cost.notnull}")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "{cost.mistype}")
    private String facilityCost;

    @NotBlank(message = "{maxPeople.notnull}")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "{maxPeople.mistype}")
    private String facilityMaxPeople;

    private String standardRoom;
    private String descriptionOtherConvenience;

    private String poolArea;

    private String numberOfFloors;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDto() {
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(String facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(String facilityCost) {
        this.facilityCost = facilityCost;
    }

    public String getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(String facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        if (facilityDto.facilityType.getFacilityTypeId() == 1 &&
                !facilityDto.numberOfFloors.matches("^[1-9][0-9]*$")) {
            errors.rejectValue("numberOfFloors", "floors.mistype","error default");
        }
        if (facilityDto.facilityType.getFacilityTypeId() == 1 &&
                !facilityDto.poolArea.matches("^[1-9][0-9]*$")) {
            errors.rejectValue("poolArea","poolArea.mistype","error default");
        }
        if (facilityDto.facilityType.getFacilityTypeId()==2 &&
        !facilityDto.numberOfFloors.matches("^[1-9][0-9]*$")){
            errors.rejectValue("numberOfFloors","floors.mistype","error default");
        }
    }
}
