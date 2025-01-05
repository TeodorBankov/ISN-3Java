package com.ISN3Java.ISN3Java.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private Long productId;
    private Long orderId;
    private Integer quantity;
    private Double price;
}
