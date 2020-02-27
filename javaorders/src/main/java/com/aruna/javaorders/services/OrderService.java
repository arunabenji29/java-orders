package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(long id);

    Order save(Order order);

    void addOrderPayments(long orderid,
                           long paymentid);
}
