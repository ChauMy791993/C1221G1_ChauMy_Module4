package com.codegym.service;

import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);
}
