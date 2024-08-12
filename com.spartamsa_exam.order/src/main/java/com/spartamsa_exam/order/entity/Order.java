package com.spartamsa_exam.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    private String name;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProductIds = new ArrayList<>();

    public Order(String name) {
        this.name = name;
    }

    public List<Long> getProductIds() {
        return orderProductIds.stream()
                .map(OrderProduct::getProductId)
                .collect(Collectors.toList());
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProductIds.add(orderProduct);
        orderProduct.setOrder(this);
    }
}
