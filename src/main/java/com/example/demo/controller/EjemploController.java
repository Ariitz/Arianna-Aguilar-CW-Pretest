package com.example.demo.controller;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.RequestEntity;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.OrderService;
import com.example.demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping
public class EjemploController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShipmentService shipmentService;

    @PostMapping("/getOrderDetails")
    public ResponseEntity getORderDetails(@RequestBody  RequestEntity requestEntity) throws InterruptedException, ExecutionException {
        Callable<OrderEntity> orderEntityCallable = orderService.getOrder(requestEntity.getOrderId());
        Callable<ShipmentEntity> shipmentEntityCallable = shipmentService.getShipment(requestEntity.getOrderId());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<OrderEntity> orderEntityFuture = executorService.submit(orderEntityCallable);
        Future<ShipmentEntity> shipmentEntityFuture = executorService.submit(shipmentEntityCallable);

        executorService.awaitTermination(2, TimeUnit.SECONDS);
        return new ResponseEntity(orderEntityFuture.get(), shipmentEntityFuture.get());
    }
}
