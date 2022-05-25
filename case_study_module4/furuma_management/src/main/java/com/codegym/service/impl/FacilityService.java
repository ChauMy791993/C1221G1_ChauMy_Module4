package com.codegym.service.impl;

import com.codegym.model.Facility;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllByFacilityNameContaining(String facilityName, Pageable pageable) {
        return iFacilityRepository.findAllByFacilityNameContaining(facilityName, pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
