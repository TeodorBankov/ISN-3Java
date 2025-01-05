package com.ISN3Java.ISN3Java.repository;

import com.ISN3Java.ISN3Java.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}