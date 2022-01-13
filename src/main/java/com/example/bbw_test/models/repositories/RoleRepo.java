package com.example.bbw_test.models.repositories;

import com.example.bbw_test.models.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
