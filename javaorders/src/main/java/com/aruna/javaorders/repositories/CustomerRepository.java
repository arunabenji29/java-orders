package com.aruna.javaorders.repositories;

import com.aruna.javaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
    List<Customer> findByCustnameContainingIgnoreCase(String name);

}
