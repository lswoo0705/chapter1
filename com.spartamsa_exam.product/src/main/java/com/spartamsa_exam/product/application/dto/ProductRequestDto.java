package com.spartamsa_exam.product.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductRequestDto {
    private String name;
    private Integer supplyPrice;
}
