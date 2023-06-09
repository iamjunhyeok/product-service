package com.iamjunhyeok.productservice.domain;

import com.iamjunhyeok.productservice.exception.ProductServiceCustomException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long id;

    private String name;

    private int price;

    private int quantity;

    public void reduceQuantity(int quantity) {
        if (this.quantity < quantity) {
            throw new ProductServiceCustomException("Product does not have sufficient Quantity");
        }
        this.quantity -= quantity;
    }
}
