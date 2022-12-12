package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AvailabilityEntity {
    private String storeNo;
    private String productId;
    private Date date;
    private Double availQty;
}
