package com.spartamsa_exam.order.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponseDto {
    private Long orderId;
    private List<Long> productIds;

    public OrderResponseDto(Long orderId, List<Long> productIds) {
        this.orderId = orderId;
        this.productIds = productIds;
    }
}
