package com.spartamsa_exam.product.dto;

public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer supplyPrice;

    public ProductResponseDto(Long id, String name, Integer supplyPrice) {
        this.id = id;
        this.name = name;
        this.supplyPrice = supplyPrice;
    }
}
