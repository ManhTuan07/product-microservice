package com.tuanit.demomicroservice.repository;

import com.tuanit.demomicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
