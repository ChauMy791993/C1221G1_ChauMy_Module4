package com.codegym.service.impl;

import com.codegym.model.Users;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<Users> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return iUserRepository.findAllByFirstNameContaining(firstName, pageable);
    }

    @Override
    public void save(Users user) {
        iUserRepository.save(user);
    }
}
