package com.aruna.javaorders.repositories;

import com.aruna.javaorders.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
//    Customer findCustomerByCustnameContaining(String name);

    List<Customer> findByCustnameContainingIgnoreCase(String name);

//    @Query(value = "SELECT * FROM customers WHERE LOWER(custname) LIKE '%mes%' ",
//    nativeQuery = true)
//    List<CustomerNamesMatch> getCustomerByCustname()
}
