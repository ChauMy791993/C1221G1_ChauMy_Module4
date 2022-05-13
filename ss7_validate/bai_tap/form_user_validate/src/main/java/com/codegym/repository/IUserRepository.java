package com.codegym.repository;


import com.codegym.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Integer> {
    Page<Users> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
