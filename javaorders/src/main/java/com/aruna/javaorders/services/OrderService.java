package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Order;

public interface OrderService {
    Order findById(long id);

    Order save(Order order);

    void addOrderPayments(long orderid,
                           long paymentid);
}
