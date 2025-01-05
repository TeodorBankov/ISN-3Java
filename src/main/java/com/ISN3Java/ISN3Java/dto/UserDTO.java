package com.ISN3Java.ISN3Java.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;

    private Set<Long> roleIds;

    private Set<Long> orderIds;
}
