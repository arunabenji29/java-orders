package com.aruna.javaorders.repositories;
import com.aruna.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long>
{
}
