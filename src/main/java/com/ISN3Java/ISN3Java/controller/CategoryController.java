package com.ISN3Java.ISN3Java.controller;

import com.ISN3Java.ISN3Java.dto.CategoryDTO;
import com.ISN3Java.ISN3Java.model.CategoryEntity;
import com.ISN3Java.ISN3Java.repository.CategoryRepository;
import com.ISN3Java.ISN3Java.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return modelMapperService.convertToDtoList(categories, CategoryDTO.class);
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return modelMapperService.convertToDto(categoryEntity);
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        // Convert DTO -> Entity
        CategoryEntity categoryEntity = modelMapperService.convertToEntity(categoryDTO);
        // Save
        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);
        // Convert Entity -> DTO (с вече генерирано ID)
        return modelMapperService.convertToDto(savedCategory);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Ъпдейтваме полета
        categoryEntity.setName(categoryDTO.getName());

        CategoryEntity updatedCategory = categoryRepository.save(categoryEntity);
        return modelMapperService.convertToDto(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
