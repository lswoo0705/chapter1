package com.spartamsa_exam.product.controller;

import com.spartamsa_exam.product.application.dto.ProductRequestDto;
import com.spartamsa_exam.product.application.dto.ProductResponseDto;
import com.spartamsa_exam.product.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    // 서버 포트
    @Value("${server.port}")
    private String serverPort;

    // 상품 추가
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        String responseMessage = productService.createProduct(productRequestDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.CREATED);
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        List<ProductResponseDto> products = productService.getProducts();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(products, headers, HttpStatus.OK);
    }

    // productRepository에 상품이 존재하는지 확인
    @GetMapping("products/{productId}")
    public boolean isProductExists(@PathVariable Long productId) {
        return productService.isProductExists(productId);
    }
}
