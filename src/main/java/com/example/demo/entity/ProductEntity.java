package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProductEntity {
    private String productId;
    private String productName;
    private String unitOfMeasure;
    private Date launchDate;
}
