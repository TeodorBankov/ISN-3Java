package com.ISN3Java.ISN3Java.dto;

import lombok.Data;
import java.util.Set;

@Data
public class OrderDTO {
    private Long id;
    private String orderDate;
    private Long userId;
    private Set<OrderItemDTO> orderItems;
}
