package com.tuanit.ordermicroservice.repository;

import com.tuanit.ordermicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
