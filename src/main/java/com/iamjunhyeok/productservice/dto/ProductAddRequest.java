package com.iamjunhyeok.productservice.dto;

import lombok.Data;

@Data
public class ProductAddRequest {
    private String name;
    private int price;
    private int quantity;
}
