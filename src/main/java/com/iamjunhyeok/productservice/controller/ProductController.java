package com.iamjunhyeok.productservice.controller;

import com.iamjunhyeok.productservice.dto.ProductAddRequest;
import com.iamjunhyeok.productservice.dto.ProductViewResponse;
import com.iamjunhyeok.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductAddRequest request) {
        Long productId = productService.addProduct(request);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductViewResponse> getProductById(@PathVariable Long id) {
        ProductViewResponse response = productService.getProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
