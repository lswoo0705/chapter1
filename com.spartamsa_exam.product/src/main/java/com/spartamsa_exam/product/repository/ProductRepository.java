package com.spartamsa_exam.product.repository;

import com.spartamsa_exam.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
