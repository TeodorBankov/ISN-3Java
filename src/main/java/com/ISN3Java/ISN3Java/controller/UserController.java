package com.ISN3Java.ISN3Java.controller;

import com.ISN3Java.ISN3Java.dto.UserDTO;
import com.ISN3Java.ISN3Java.model.UserEntity;
import com.ISN3Java.ISN3Java.repository.UserRepository;
import com.ISN3Java.ISN3Java.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return modelMapperService.convertToDtoList(users, UserDTO.class);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapperService.convertToDto(user);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = modelMapperService.convertToEntity(userDTO);
        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapperService.convertToDto(savedUser);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update полета
        user.setUsername(userDTO.getUsername());
        // Ако имаш логика за ъпдейт на роли, може да заредиш RoleEntity и да сетнеш setRoles(...) и т.н.

        UserEntity updatedUser = userRepository.save(user);
        return modelMapperService.convertToDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
