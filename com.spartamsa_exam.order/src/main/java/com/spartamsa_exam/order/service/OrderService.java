package com.spartamsa_exam.order.service;

import com.spartamsa_exam.order.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductClient productClient;

    // 주문 단건 조회
    public String getOrder(String orderId) {
        return null;
    }
}
