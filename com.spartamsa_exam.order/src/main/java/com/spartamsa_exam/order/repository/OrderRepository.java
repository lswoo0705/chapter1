package com.spartamsa_exam.order.repository;

import com.spartamsa_exam.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
