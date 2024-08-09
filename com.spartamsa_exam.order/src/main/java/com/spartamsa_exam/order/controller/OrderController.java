package com.spartamsa_exam.order.controller;

import com.spartamsa_exam.order.dto.AddProductToOrderRequestDto;
import com.spartamsa_exam.order.dto.OrderRequestDto;
import com.spartamsa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // 주문 추가
    @PostMapping("/order")
    public String createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    // 주문에 상품 추가하기
    @PutMapping("/order/{orderId}")
    public String addProductToOrder(@PathVariable Long orderId, @RequestBody AddProductToOrderRequestDto addProductToOrderRequestDto) {
        return orderService.addProductToOrder(orderId, addProductToOrderRequestDto);
    }

    // 주문 단건 조회
    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String orderId) {
        return orderService.getOrder(orderId);
    }
}
