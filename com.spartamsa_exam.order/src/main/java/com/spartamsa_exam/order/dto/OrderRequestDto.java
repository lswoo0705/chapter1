package com.spartamsa_exam.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderRequestDto {
    private String name;
    private List<Long> productIds;
}
