package com.tuanit.demomicroservice.repository;

import com.tuanit.demomicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
