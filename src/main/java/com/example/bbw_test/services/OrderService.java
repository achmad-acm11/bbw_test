package com.example.bbw_test.services;

import java.util.Random;

import javax.transaction.Transactional;

// import com.example.bbw_test.models.entities.Client;
import com.example.bbw_test.models.entities.Order;
import com.example.bbw_test.models.repositories.OrderRepo;
import com.example.bbw_test.request.OrderRequest;
import com.example.bbw_test.response.OrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo repo;

    public Order getOrderService(Integer id) {
        return repo.findById(id).get();
    }

    public OrderResponse paymentService(OrderRequest req) {
        Order order = new Order();

        // Mapping
        order.setClientId(req.getClient_id());
        order.setAmount(req.getAmount());
        order.setNote(req.getNote());
        Random rand = new Random();
        Long num = rand.nextLong(25);

        order.setTransactionNumber(num);

        // Get Order
        repo.save(order);

        return new OrderResponse("000", "Success", order.getTransactionNumber());
    }
}
