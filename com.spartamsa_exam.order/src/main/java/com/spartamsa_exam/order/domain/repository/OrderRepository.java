package com.spartamsa_exam.order.domain.repository;

import com.spartamsa_exam.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
