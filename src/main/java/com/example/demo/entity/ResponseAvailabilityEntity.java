package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)))
public class ResponseAvailabilityEntity {
    private String storeNo;
    private String prodcutId;
    private Double reqQty;
    private Date reqDate;
    private String status;
}
