package com.example.bbw_test.models.repositories;

import java.util.Optional;

import com.example.bbw_test.models.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    
    Optional<Client> findByVirtualAccount(Long virtualAccount);
}
