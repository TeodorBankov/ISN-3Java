package com.ISN3Java.ISN3Java.repository;

import com.ISN3Java.ISN3Java.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}