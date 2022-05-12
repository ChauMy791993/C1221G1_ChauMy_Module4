package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> findAllByFirstNameContaining(String firstName, Pageable pageable);

//    @Query(value = "select u.* from user as u where u.first_name like :firstName",nativeQuery = true)
//    Page<User> findAllByFistName(@Param("firstName") String firstName,Pageable pageable);

}
