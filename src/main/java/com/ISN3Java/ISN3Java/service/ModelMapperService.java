package com.ISN3Java.ISN3Java.service;

import com.ISN3Java.ISN3Java.dto.*;
import com.ISN3Java.ISN3Java.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperService {

    private final ModelMapper modelMapper;

    public ModelMapperService() {
        this.modelMapper = new ModelMapper();
    }

    // Entity to DTO mappings
    public UserDTO convertToDto(UserEntity user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public OrderDTO convertToDto(OrderEntity order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public ProductDTO convertToDto(ProductEntity product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public OrderItemDTO convertToDto(OrderItemEntity orderItem) {
        return modelMapper.map(orderItem, OrderItemDTO.class);
    }

    public CategoryDTO convertToDto(CategoryEntity category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public RoleDTO convertToDto(RoleEntity role) {
        return modelMapper.map(role, RoleDTO.class);
    }

    // DTO to Entity mappings
    public UserEntity convertToEntity(UserDTO userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }

    public OrderEntity convertToEntity(OrderDTO orderDto) {
        return modelMapper.map(orderDto, OrderEntity.class);
    }

    public ProductEntity convertToEntity(ProductDTO productDto) {
        return modelMapper.map(productDto, ProductEntity.class);
    }

    public OrderItemEntity convertToEntity(OrderItemDTO orderItemDto) {
        return modelMapper.map(orderItemDto, OrderItemEntity.class);
    }

    public CategoryEntity convertToEntity(CategoryDTO categoryDto) {
        return modelMapper.map(categoryDto, CategoryEntity.class);
    }

    public RoleEntity convertToEntity(RoleDTO roleDto) {
        return modelMapper.map(roleDto, RoleEntity.class);
    }

    // Generic method for DTO to Entity collections
    public <D, E> List<E> convertToEntityList(List<D> dtos, Class<E> entityClass) {
        return dtos.stream()
                .map(dto -> modelMapper.map(dto, entityClass))
                .collect(Collectors.toList());
    }

    // Generic method for Entity to DTO collections
    public <D, E> List<D> convertToDtoList(List<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList());
    }

}