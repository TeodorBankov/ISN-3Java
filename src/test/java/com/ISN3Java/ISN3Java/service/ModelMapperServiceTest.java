package com.ISN3Java.ISN3Java.service;

import com.ISN3Java.ISN3Java.dto.*;
import com.ISN3Java.ISN3Java.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelMapperServiceTest {

    private ModelMapperService modelMapperService;

    @BeforeEach
    void setUp() {
        modelMapperService = new ModelMapperService();
    }

    @Test
    void testConvertToDtoListUser() {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId(1L);
        userEntity1.setUsername("testUser1");
        userEntity1.setPassword("password1");

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId(2L);
        userEntity2.setUsername("testUser2");
        userEntity2.setPassword("password2");

        List<UserEntity> userEntities = List.of(userEntity1, userEntity2);

        List<UserDTO> userDtos = modelMapperService.convertToDtoList(userEntities, UserDTO.class);

        // Validate the conversion
        assertEquals(2, userDtos.size());
        assertEquals("testUser1", userDtos.get(0).getUsername());
        assertEquals("testUser2", userDtos.get(1).getUsername());
    }

    @Test
    void testConvertToEntityListUser() {
        UserDTO userDto1 = new UserDTO();
        userDto1.setId(1L);
        userDto1.setUsername("testUser1");

        UserDTO userDto2 = new UserDTO();
        userDto2.setId(2L);
        userDto2.setUsername("testUser2");

        List<UserDTO> userDtos = List.of(userDto1, userDto2);

        List<UserEntity> userEntities = modelMapperService.convertToEntityList(userDtos, UserEntity.class);

        // Validate the conversion
        assertEquals(2, userEntities.size());
        assertEquals("testUser1", userEntities.get(0).getUsername());
        assertEquals("testUser2", userEntities.get(1).getUsername());
    }

    @Test
    void testConvertToDtoListCategory() {
        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setId(1L);
        categoryEntity1.setName("Category1");

        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setId(2L);
        categoryEntity2.setName("Category2");

        List<CategoryEntity> categoryEntities = List.of(categoryEntity1, categoryEntity2);

        List<CategoryDTO> categoryDtos = modelMapperService.convertToDtoList(categoryEntities, CategoryDTO.class);

        // Validate the conversion
        assertEquals(2, categoryDtos.size());
        assertEquals("Category1", categoryDtos.get(0).getName());
        assertEquals("Category2", categoryDtos.get(1).getName());
    }

    @Test
    void testConvertToEntityListCategory() {
        CategoryDTO categoryDto1 = new CategoryDTO();
        categoryDto1.setId(1L);
        categoryDto1.setName("Category1");

        CategoryDTO categoryDto2 = new CategoryDTO();
        categoryDto2.setId(2L);
        categoryDto2.setName("Category2");

        List<CategoryDTO> categoryDtos = List.of(categoryDto1, categoryDto2);

        List<CategoryEntity> categoryEntities = modelMapperService.convertToEntityList(categoryDtos, CategoryEntity.class);

        // Validate the conversion
        assertEquals(2, categoryEntities.size());
        assertEquals("Category1", categoryEntities.get(0).getName());
        assertEquals("Category2", categoryEntities.get(1).getName());
    }

    @Test
    void testConvertToDtoListProduct() {
        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setId(10L);
        productEntity1.setName("Test Product 1");
        productEntity1.setPrice(10.99);

        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setId(20L);
        productEntity2.setName("Test Product 2");
        productEntity2.setPrice(20.99);

        List<ProductEntity> productEntities = List.of(productEntity1, productEntity2);

        List<ProductDTO> productDtos = modelMapperService.convertToDtoList(productEntities, ProductDTO.class);

        assertEquals(2, productDtos.size());
        assertEquals("Test Product 1", productDtos.get(0).getName());
        assertEquals("Test Product 2", productDtos.get(1).getName());
    }

    @Test
    void testConvertToEntityListRole() {
        RoleDTO roleDto1 = new RoleDTO();
        roleDto1.setId(100L);
        roleDto1.setRoleName("ROLE_ADMIN");

        RoleDTO roleDto2 = new RoleDTO();
        roleDto2.setId(200L);
        roleDto2.setRoleName("ROLE_USER");

        List<RoleDTO> roleDtos = List.of(roleDto1, roleDto2);

        List<RoleEntity> roleEntities = modelMapperService.convertToEntityList(roleDtos, RoleEntity.class);

        assertEquals(2, roleEntities.size());
        assertEquals("ROLE_ADMIN", roleEntities.get(0).getRoleName());
        assertEquals("ROLE_USER", roleEntities.get(1).getRoleName());
    }

    @Test
    void testConvertToDtoListOrder() {
        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setId(1L);
        orderEntity1.setOrderDate("2023-01-01");

        OrderEntity orderEntity2 = new OrderEntity();
        orderEntity2.setId(2L);
        orderEntity2.setOrderDate("2023-01-02");

        List<OrderEntity> orderEntities = List.of(orderEntity1, orderEntity2);

        List<OrderDTO> orderDtos = modelMapperService.convertToDtoList(orderEntities, OrderDTO.class);

        assertEquals(2, orderDtos.size());
        assertEquals("2023-01-01", orderDtos.get(0).getOrderDate());
        assertEquals("2023-01-02", orderDtos.get(1).getOrderDate());
    }
}
