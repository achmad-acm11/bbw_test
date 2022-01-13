package com.example.bbw_test.models.repositories;

import com.example.bbw_test.models.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    // @Query("SELECT * FROM Order d WHERE d.virtualAccount = ?1")
    // Order getByVirtualAccount(Long virtualAccount);
}
