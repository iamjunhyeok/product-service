package com.iamjunhyeok.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductViewResponse {
    private Long id;
    private String name;
    private int price;
    private int quantity;
}
