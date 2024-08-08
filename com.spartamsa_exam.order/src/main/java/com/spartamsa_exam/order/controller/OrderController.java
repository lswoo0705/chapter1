package com.spartamsa_exam.order.controller;

import com.spartamsa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // 주문 단건 조회
    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String orderId) {
        return orderService.getOrder(orderId);
    }
}
