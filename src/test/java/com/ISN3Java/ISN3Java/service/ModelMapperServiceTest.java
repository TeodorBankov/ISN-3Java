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

}
