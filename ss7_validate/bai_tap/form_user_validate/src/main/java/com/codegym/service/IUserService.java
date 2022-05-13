package com.codegym.service;

import com.codegym.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<Users> findAllByFirstNameContaining(String firstName, Pageable pageable);

    void save(Users user);
}
