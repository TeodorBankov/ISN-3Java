package com.ISN3Java.ISN3Java.repository;

import com.ISN3Java.ISN3Java.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.price <= :budget")
    List<ProductEntity> findProductsByPriceLessThan(@Param("budget") Double budget);

}