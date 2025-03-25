package com.marcobikes.productcatalogservice.controller;

import com.marcobikes.productcatalogservice.dto.ProductDTO;
import com.marcobikes.productcatalogservice.dto.ProductOptionDTO;
import com.marcobikes.productcatalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    // In-memory product repository

    @Autowired
    private ProductService productService;

    // GET /products/{id} - Retrieve product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    // GET /products - Retrieve all products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // POST /products - Add a new product
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDTO));
    }

    // GET /products/{id}/options - Retrieve customization options for a product
    @GetMapping("/{id}/options")
    public ResponseEntity<List<ProductOptionDTO>> getProductOptions(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductOptions(id));
    }

    //GET /products/{id}/base-price - Retrieve the price of each product
    @GetMapping("/{id}/base-price")
    public ResponseEntity<Double> getBasePrice(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getBasePrice(id));
    }

}
