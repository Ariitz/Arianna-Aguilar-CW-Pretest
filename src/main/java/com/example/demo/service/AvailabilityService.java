package com.example.demo.service;

import com.example.demo.entity.AvailabilityEntity;
import com.example.demo.entity.CapacityEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@Service
public class AvailabilityService {
    AvailabilityEntity availability1 = new AvailabilityEntity("Store001", "Prod1", new Date(2021 - 02 - 19), 1.0);
    AvailabilityEntity availability2 = new AvailabilityEntity("Store001", "Prod1", new Date(2021 - 02 - 20), 3.0);
    AvailabilityEntity availability3 = new AvailabilityEntity("Store001", "Prod1", new Date(2021 - 02 - 21), 0.0);
    List<AvailabilityEntity> availability = Arrays.asList(availability1, availability2, availability3);

    CapacityEntity capacity1 = new CapacityEntity("Store001", "Prod1", new Date(2021 - 02 - 19), 0.0);
    CapacityEntity capacity2 = new CapacityEntity("Store001", "Prod1", new Date(2021 - 02 - 20), 2.0);
    CapacityEntity capacity3 = new CapacityEntity(" Store001", "Prod1", new Date(2021 - 02 - 21), 2.0);
    List<CapacityEntity> capacity = Arrays.asList(capacity1, capacity2, capacity3);

    public Callable<Double> getAvailability(final Date date){
        return () -> availability.stream().filter( availabilityEntity -> availabilityEntity.getDate().equals(date)).findFirst().orElse(null).getAvailQty();
    }
    public Callable<Double> getCapacity(final Date date){
        return () -> capacity.stream().filter( availabilityEntity -> availabilityEntity.getDate().equals(date)).findFirst().orElse(null).getNoOfOrdersAccpted();
    }


}
