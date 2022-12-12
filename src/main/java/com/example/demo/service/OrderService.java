package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ShipmentEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Callable;

@Service
public class OrderService {
    private OrderEntity orderEntity = new OrderEntity("Order1", "Prod1", 2.0);

    public Callable<OrderEntity> getOrder(final String orderId){
        return () -> orderEntity;
    }
}
