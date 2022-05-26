package com.codegym.service;

import com.codegym.model.EducationDegree;
import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllByEmployee(String employeeName, String employeeAddress, String positionId, Pageable pageable);

    void save(Employee employee);

    void delete(Employee employee);

    void edit(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();

}
