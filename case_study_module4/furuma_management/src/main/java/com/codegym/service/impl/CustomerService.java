package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAllByCustomer
            (String customerName, String customerAddress, String customerTypeId, Pageable pageable) {
        if (customerTypeId.equals("")) {
            return iCustomerRepository.findAllByCustomerNameContainingAndCustomerAddressContaining
                    (customerName, customerAddress, pageable);
        } else {
            return iCustomerRepository.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId
                    (customerName, customerAddress, Integer.parseInt(customerTypeId), pageable);
        }
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
