package com.ISN3Java.ISN3Java.controller;

import com.ISN3Java.ISN3Java.dto.ProductDTO;
import com.ISN3Java.ISN3Java.model.ProductEntity;
import com.ISN3Java.ISN3Java.repository.ProductRepository;
import com.ISN3Java.ISN3Java.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return modelMapperService.convertToDtoList(products, ProductDTO.class);
    }

    @GetMapping("/by-price")
    public List<ProductDTO> getProductsByPriceLessThan(@RequestParam Double budget) {
        List<ProductEntity> products = productRepository.findProductsByPriceLessThan(budget);
        return modelMapperService.convertToDtoList(products, ProductDTO.class);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapperService.convertToDto(product);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        ProductEntity productEntity = modelMapperService.convertToEntity(productDTO);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return modelMapperService.convertToDto(savedProduct);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        // Ако искаш да ъпдейтваш и категория:
        // тук може да заредиш от база CategoryEntity по productDTO.getCategoryId() и да я сетнеш

        ProductEntity updatedProduct = productRepository.save(product);
        return modelMapperService.convertToDto(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
