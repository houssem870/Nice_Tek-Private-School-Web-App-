package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);

}
