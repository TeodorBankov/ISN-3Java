package com.ISN3Java.ISN3Java.dto;

import lombok.Data;
import java.util.Set;

@Data
public class CategoryDTO {
    private Long id;
    private String name;

    private Set<Long> productIds;
}
