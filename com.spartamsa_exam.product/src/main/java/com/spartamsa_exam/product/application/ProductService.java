package com.spartamsa_exam.product.application;

import com.spartamsa_exam.product.application.dto.ProductRequestDto;
import com.spartamsa_exam.product.application.dto.ProductResponseDto;
import com.spartamsa_exam.product.domain.Product;
import com.spartamsa_exam.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 상품 추가
    @CacheEvict(cacheNames = "productAllCache", allEntries = true)
    public String createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto.getName(), productRequestDto.getSupplyPrice());
        productRepository.save(product);

        return "Create Product Success";
    }

    // 상품 목록 조회
    @Cacheable(cacheNames = "productAllCache")
    public List<ProductResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> new ProductResponseDto(product.getId(), product.getName(), product.getSupplyPrice()))
                .toList();
    }

    // productRepository에 상품이 존재하는지 확인
    public boolean isProductExists(Long productId) {
        return productRepository.existsById(productId);
    }
}
