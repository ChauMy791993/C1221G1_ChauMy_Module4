package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<User> findAllByFirstNameContaining(String firstName, Pageable pageable);

    void save(User user);
}
