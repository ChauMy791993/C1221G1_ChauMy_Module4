package com.codegym.repository;

import com.codegym.model.Facility;
import com.codegym.model.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    Page<Facility> findAllByFacilityNameContaining(String facilityName, Pageable pageable);
}
