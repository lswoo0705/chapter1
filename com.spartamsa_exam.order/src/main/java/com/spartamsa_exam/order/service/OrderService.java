package com.spartamsa_exam.order.service;

import com.spartamsa_exam.order.client.ProductClient;
import com.spartamsa_exam.order.dto.OrderRequestDto;
import com.spartamsa_exam.order.entity.Order;
import com.spartamsa_exam.order.entity.OrderProduct;
import com.spartamsa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    // 주문 추가
    public String createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order(orderRequestDto.getName());

        for (Long productId : orderRequestDto.getProductIds()) {
            OrderProduct orderProduct = new OrderProduct(productId);
            order.addOrderProduct(orderProduct);
        }

        orderRepository.save(order);

        return "Create Order Success";
    }

    // 주문 단건 조회
    public String getOrder(String orderId) {
        return null;
    }
}
