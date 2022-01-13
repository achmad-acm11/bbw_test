package com.example.bbw_test.models.repositories;

import com.example.bbw_test.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
