package com.ISN3Java.ISN3Java.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Integer quantity;
    private Double price;

    // Getters and setters
}
