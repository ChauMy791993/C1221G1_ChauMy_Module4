package com.codegym.service;

import com.codegym.model.BorrowBookCode;

public interface IBorrowBookCodeService {
    void save(BorrowBookCode borrowBookCode);

    BorrowBookCode findById(String id);

    void delete (BorrowBookCode borrowBookCode);
}
