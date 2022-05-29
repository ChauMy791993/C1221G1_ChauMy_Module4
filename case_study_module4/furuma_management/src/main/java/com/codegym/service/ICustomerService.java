package com.codegym.service;

import com.codegym.dto.ICustomerUseService;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllByCustomer(String customerName, String customerAddress, String customerTypeId, Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();

    Page<ICustomerUseService> findAllCustomerHaveBooking(Pageable pageable);

}
