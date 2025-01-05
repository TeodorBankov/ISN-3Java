package com.ISN3Java.ISN3Java.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    // Getters and setters
}