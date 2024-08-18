package com.spartamsa_exam.product.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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
