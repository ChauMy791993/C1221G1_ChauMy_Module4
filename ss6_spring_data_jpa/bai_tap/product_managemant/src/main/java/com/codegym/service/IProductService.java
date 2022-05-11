package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    Product findById(Integer id);
}
