package com.codegym.service.impl;

import com.codegym.model.TypeProduct;
import com.codegym.repository.ITypeProductRepository;
import com.codegym.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {

    @Autowired
    private ITypeProductRepository iTypeProductRepository;
    @Override
    public List<TypeProduct> findAll() {
        return iTypeProductRepository.findAll();
    }
}
