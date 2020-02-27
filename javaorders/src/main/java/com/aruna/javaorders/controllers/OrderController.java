package com.aruna.javaorders.controllers;

import com.aruna.javaorders.models.Order;
import com.aruna.javaorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    public OrderService orderService;

    //GET localhost:2023/orders/order/7
    @GetMapping(value = "/order/{orderId}",
            produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable long orderId){

        Order myOrder = orderService.findById(orderId);
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }

    //GET localhost:2023/orders/advanceAmount
    @GetMapping(value = "/advanceAmount",
            produces = {"application/json"})
    public ResponseEntity<?> findAllOrders(){

        List<Order> myOrder = orderService.findAll();
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }
}
