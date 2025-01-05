package com.ISN3Java.ISN3Java.repository;

import com.ISN3Java.ISN3Java.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}