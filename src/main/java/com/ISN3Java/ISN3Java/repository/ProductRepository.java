package com.ISN3Java.ISN3Java.repository;

import com.ISN3Java.ISN3Java.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}