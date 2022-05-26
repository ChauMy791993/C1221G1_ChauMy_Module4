package com.codegym.service;

import com.codegym.dto.FacilityDto;
import com.codegym.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAllByFacilityNameContaining(String facilityName, Pageable pageable);

    void save(FacilityDto facilityDto);

    List<Facility> findAll();
}
