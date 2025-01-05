package com.ISN3Java.ISN3Java.dto;

import lombok.Data;
import java.util.Set;

@Data
public class RoleDTO {
    private Long id;
    private String roleName;

    private Set<Long> userIds;
}
