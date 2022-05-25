package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId
            (String customerName, String customerAddress, Integer customerTypeId, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining
            (String customerName, String customerAddress, Pageable pageable);
}
