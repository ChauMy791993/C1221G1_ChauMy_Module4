package com.codegym.repository;

import com.codegym.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeProductRepository extends JpaRepository<TypeProduct,Integer> {
}
