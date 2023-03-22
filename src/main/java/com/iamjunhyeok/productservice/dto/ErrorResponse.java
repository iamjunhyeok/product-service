package com.iamjunhyeok.productservice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;

    public ErrorResponse(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}
