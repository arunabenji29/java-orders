package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer findById(long id);

    List<Customer> findAllByCustname(String name);

    Customer save(Customer customer);

}
