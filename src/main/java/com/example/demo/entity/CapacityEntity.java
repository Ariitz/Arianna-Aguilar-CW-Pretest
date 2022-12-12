package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CapacityEntity {
    private String storeNo;
    private String prodcutId;
    private Date date;
    private Double noOfOrdersAccpted;
}
