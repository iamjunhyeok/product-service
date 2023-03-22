package com.iamjunhyeok.productservice.service;

import com.iamjunhyeok.productservice.domain.Product;
import com.iamjunhyeok.productservice.dto.ProductAddRequest;
import com.iamjunhyeok.productservice.dto.ProductViewResponse;
import com.iamjunhyeok.productservice.exception.ProductServiceCustomException;
import com.iamjunhyeok.productservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Long addProduct(ProductAddRequest request) {
        log.info("Adding Product..");

        Product product = Product.builder()
                .name(request.getName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product Created");

        return product.getId();
    }

    public ProductViewResponse getProductById(Long id) {
        log.info("Get the product for productId: {}", id);

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductServiceCustomException("Product with given id not found"));

        ProductViewResponse response = new ProductViewResponse();
        BeanUtils.copyProperties(product, response);

        return response;
    }
}
