package com.example.bbw_test.controllers;

import com.example.bbw_test.request.OrderRequest;
import com.example.bbw_test.response.OrderResponse;
import com.example.bbw_test.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/va")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, value = "/payment")
    public ResponseEntity payment(@RequestBody OrderRequest req) {
        OrderResponse res = service.paymentService(req);
        return new ResponseEntity<OrderResponse>(res, HttpStatus.OK);
    }

}
