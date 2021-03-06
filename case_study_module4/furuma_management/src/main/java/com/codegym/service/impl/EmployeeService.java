package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllByEmployee(String employeeName, String employeeAddress, String positionId, Pageable pageable) {
        if (positionId.equals("")) {
            return iEmployeeRepository.
                    findAllByEmployeeNameContainingAndEmployeeAddressContaining(employeeName, employeeAddress, pageable);
        } else {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionId
                    (employeeName, employeeAddress, Integer.parseInt(positionId), pageable);
        }
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        iEmployeeRepository.delete(employee);
    }

    @Override
    public void edit(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
