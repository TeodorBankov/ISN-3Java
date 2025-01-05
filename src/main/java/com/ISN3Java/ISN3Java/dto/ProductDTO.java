package com.ISN3Java.ISN3Java.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;

    private Long categoryId;
}
