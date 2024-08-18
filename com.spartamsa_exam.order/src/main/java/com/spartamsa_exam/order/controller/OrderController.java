package com.spartamsa_exam.order.controller;

import com.spartamsa_exam.order.application.dto.AddProductToOrderRequestDto;
import com.spartamsa_exam.order.application.dto.OrderRequestDto;
import com.spartamsa_exam.order.application.dto.OrderResponseDto;
import com.spartamsa_exam.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    // 서버 포트
    @Value("${server.port}")
    private String serverPort;

    // 주문 추가
    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        String response = orderService.createOrder(orderRequestDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
    }

    // 주문에 상품 추가하기
    @PutMapping("/order/{orderId}")
    public ResponseEntity<String> addProductToOrder(@PathVariable Long orderId, @RequestBody AddProductToOrderRequestDto addProductToOrderRequestDto) {
        String response = orderService.addProductToOrder(orderId, addProductToOrderRequestDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    // 주문 단건 조회
    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("orderId") Long orderId) {
        OrderResponseDto orderResponseDto = orderService.getOrder(orderId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(orderResponseDto, headers, HttpStatus.OK);
    }
}
