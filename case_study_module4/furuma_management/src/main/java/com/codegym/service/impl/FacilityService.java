package com.codegym.service.impl;

import com.codegym.dto.FacilityDto;
import com.codegym.model.Facility;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllByFacilityNameContaining(String facilityName, Pageable pageable) {
        return iFacilityRepository.findAllByFacilityNameContaining(facilityName, pageable);
    }

    @Override
    public void save(FacilityDto facilityDto) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facility.setFacilityArea(Integer.parseInt(facilityDto.getFacilityArea()));
        facility.setFacilityCost(Double.parseDouble(facilityDto.getFacilityCost()));
        facility.setFacilityMaxPeople(Integer.parseInt(facilityDto.getFacilityMaxPeople()));
        facility.setPoolArea(Double.parseDouble(facilityDto.getPoolArea()));
        facility.setNumberOfFloors(Integer.parseInt(facilityDto.getNumberOfFloors()));
        iFacilityRepository.save(facility);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }
}
