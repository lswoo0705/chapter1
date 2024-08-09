package com.spartamsa_exam.product.dto;

import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer supplyPrice;
    private String serverPort;

    public ProductResponseDto(Long id, String name, Integer supplyPrice, String serverPort) {
        this.id = id;
        this.name = name;
        this.supplyPrice = supplyPrice;
        this.serverPort = serverPort;
    }
}
