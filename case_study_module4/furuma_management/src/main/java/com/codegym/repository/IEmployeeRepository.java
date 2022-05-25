package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionId
            (String employeeName, String employeeAddress, Integer positionId, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContaining
            (String employeeName, String employeeAddress, Pageable pageable);
}
