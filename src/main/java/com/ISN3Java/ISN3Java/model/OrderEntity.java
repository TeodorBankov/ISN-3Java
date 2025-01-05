package com.ISN3Java.ISN3Java.model;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order")
    private Set<OrderItemEntity> orderItems;

    // Getters and setters
}
