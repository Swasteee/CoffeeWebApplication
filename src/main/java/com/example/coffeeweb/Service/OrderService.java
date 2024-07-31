package com.example.coffeeweb.Service;


import com.example.coffeeweb.Entity.Order;
import com.example.coffeeweb.Pojo.OrderPojo;

import java.util.List;

public interface OrderService {

    Integer
    saveOrder(OrderPojo orderPojo);

    List<Order> findAll();

    Order findById(Integer id);

    void deleteById(Integer id);
}