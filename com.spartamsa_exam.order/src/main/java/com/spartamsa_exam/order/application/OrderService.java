package com.spartamsa_exam.order.application;

import com.spartamsa_exam.order.infrastructure.ProductClient;
import com.spartamsa_exam.order.application.dto.AddProductToOrderRequestDto;
import com.spartamsa_exam.order.application.dto.OrderRequestDto;
import com.spartamsa_exam.order.application.dto.OrderResponseDto;
import com.spartamsa_exam.order.domain.Order;
import com.spartamsa_exam.order.domain.OrderProduct;
import com.spartamsa_exam.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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

    // 주문에 상품 추가하기
    public String addProductToOrder(Long orderId, AddProductToOrderRequestDto addProductToOrderRequestDto) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("해당 주문은 존재하지 않습니다."));

        if (!productClient.isProductExists(addProductToOrderRequestDto.getProductId())) {
            throw new IllegalArgumentException("해당 상품은 존재하지 않습니다.");
        }

        order.addOrderProduct(new OrderProduct(addProductToOrderRequestDto.getProductId()));

        orderRepository.save(order);

        return "Add Product To Order";
    }

    // 주문 단건 조회
    @Cacheable(cacheNames = "orderCache", key = "args[0]")
    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("해당 주문은 존재하지 않습니다.")
        );

        return new OrderResponseDto(order.getOrderId(), order.getProductIds());
    }
}
