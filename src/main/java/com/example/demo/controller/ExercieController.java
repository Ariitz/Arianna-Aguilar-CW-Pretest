package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping
public class ExercieController {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private SortService sortService;

    @PostMapping("/sortProducts")
    public ProductList sortProducts(@RequestBody  ProductList productList) throws InterruptedException, ExecutionException {
        return sortService.sortService(productList);
    }

    @PostMapping("getProdAvailability")
    public Object getProdAvailability(@RequestBody AvailabilityEntity availabilityEntity) throws ExecutionException, InterruptedException {
        Callable<Double> available = availabilityService.getAvailability(availabilityEntity.getDate());
        Callable<Double> capable = availabilityService.getCapacity(availabilityEntity.getDate());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Double> availability = executorService.submit(available);
        Future<Double> capacity = executorService.submit(capable);
        if(availability.get() > 0.0 && capacity.get() == 0.0){
            return new ResponseAvailabilityEntity(availabilityEntity.getStoreNo(), availabilityEntity.getProductId(), availabilityEntity.getAvailQty(), availabilityEntity.getDate(), "No Capacity");
        } else if(availability.get() > 0.0 && capacity.get() > 0.0) {
            return new ResponseAvailabilityEntity(availabilityEntity.getStoreNo(), availabilityEntity.getProductId(), availabilityEntity.getAvailQty(), availabilityEntity.getDate(), "Available");
        }
        return HttpStatus.NO_CONTENT;
    }
}
