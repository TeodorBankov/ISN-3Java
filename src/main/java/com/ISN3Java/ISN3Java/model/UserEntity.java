package com.ISN3Java.ISN3Java.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data // lombok generates getters, setters, toString, equals, hashcode and a constructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "user")
    private Set<OrderEntity> orders;
}
