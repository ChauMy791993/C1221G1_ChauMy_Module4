package com.codegym.repository;

import com.codegym.model.BorrowBookCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookCodeRepository extends JpaRepository<BorrowBookCode,Integer> {
}
