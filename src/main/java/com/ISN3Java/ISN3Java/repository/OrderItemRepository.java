package com.ISN3Java.ISN3Java.repository;

import com.ISN3Java.ISN3Java.model.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}