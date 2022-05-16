package com.codegym.service.impl;

import com.codegym.model.BorrowBookCode;
import com.codegym.repository.IBorrowBookCodeRepository;
import com.codegym.service.IBorrowBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookCodeService implements IBorrowBookCodeService {

    @Autowired
    private IBorrowBookCodeRepository iBorrowBookCodeRepository;

    @Override
    public void save(BorrowBookCode borrowBookCode) {
        iBorrowBookCodeRepository.save(borrowBookCode);
    }

    @Override
    public BorrowBookCode findById(String id) {
        return iBorrowBookCodeRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    @Override
    public void delete(BorrowBookCode borrowBookCode) {
        iBorrowBookCodeRepository.delete(borrowBookCode);
    }
}
