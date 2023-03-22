package com.iamjunhyeok.productservice.repository;

import com.iamjunhyeok.productservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
