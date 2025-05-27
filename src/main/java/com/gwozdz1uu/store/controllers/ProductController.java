package com.gwozdz1uu.store.controllers;

import com.gwozdz1uu.store.dtos.ProductDto;
import com.gwozdz1uu.store.entities.Product;
import com.gwozdz1uu.store.mappers.ProductMapper;
import com.gwozdz1uu.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(@RequestParam(required = false,name="categoryId") Byte categoryId) {

        List<Product> products;
        if(categoryId == null){
            products = productRepository.findAllWithCategory();
        }
        else products = productRepository.findAllByCategoryId(categoryId);

        return products.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        var product = productRepository.findById(productId).orElse(null);
        if(product == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productMapper.toDto(product));
    }

}
