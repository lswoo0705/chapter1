package com.spartamsa_exam.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Long orderProductId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "product_id")
    private Long productId;

    public OrderProduct(Long productId) {
        this.productId = productId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
