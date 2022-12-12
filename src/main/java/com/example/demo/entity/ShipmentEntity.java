package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ShipmentEntity {
    String orderId;
    String shipmentId;
    String productId;
    Date shipmentDate;
    Double qty;
}
