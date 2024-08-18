package com.spartamsa_exam.product.domain.repository;

import com.spartamsa_exam.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
