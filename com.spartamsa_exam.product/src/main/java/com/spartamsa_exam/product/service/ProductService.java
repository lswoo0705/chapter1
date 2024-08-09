package com.spartamsa_exam.product.service;

import com.spartamsa_exam.product.dto.ProductRequestDto;
import com.spartamsa_exam.product.dto.ProductResponseDto;
import com.spartamsa_exam.product.entity.Product;
import com.spartamsa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 상품 추가
    public String createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto.getName(), productRequestDto.getSupplyPrice());
        productRepository.save(product);
        return "Create Product Success";
    }

    // 상품 목록 조회
    public List<ProductResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponseDto> productList = products.stream()
                .map(product -> new ProductResponseDto(product.getId(), product.getName(), product.getSupplyPrice()))
                .toList();

        return productList;
    }
}
