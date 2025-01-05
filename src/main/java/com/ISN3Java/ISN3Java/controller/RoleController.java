package com.ISN3Java.ISN3Java.controller;

import com.ISN3Java.ISN3Java.dto.RoleDTO;
import com.ISN3Java.ISN3Java.model.RoleEntity;
import com.ISN3Java.ISN3Java.repository.RoleRepository;
import com.ISN3Java.ISN3Java.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        List<RoleEntity> roles = roleRepository.findAll();
        return modelMapperService.convertToDtoList(roles, RoleDTO.class);
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        RoleEntity role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return modelMapperService.convertToDto(role);
    }

    @PostMapping
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
        RoleEntity roleEntity = modelMapperService.convertToEntity(roleDTO);
        RoleEntity savedRole = roleRepository.save(roleEntity);
        return modelMapperService.convertToDto(savedRole);
    }

    @PutMapping("/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        RoleEntity role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setRoleName(roleDTO.getRoleName());

        RoleEntity updatedRole = roleRepository.save(role);
        return modelMapperService.convertToDto(updatedRole);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}
