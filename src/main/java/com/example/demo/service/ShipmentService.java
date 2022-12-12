package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ShipmentEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Callable;

@Service
public class ShipmentService {
    private ShipmentEntity shipmentEntity = new ShipmentEntity("Order1","Ship1", "Prod1", new Date(2021-02-19), 2.0);

    public Callable<ShipmentEntity> getShipment(final String orderId){
        return () -> shipmentEntity;
    }
}
