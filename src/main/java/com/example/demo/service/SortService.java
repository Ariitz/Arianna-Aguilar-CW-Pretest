package com.example.demo.service;

import com.example.demo.entity.ProductList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortService {
    public ProductList sortService(ProductList productList) {
        List sortedList = productList.getProductList().stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        return null;
    }
}
