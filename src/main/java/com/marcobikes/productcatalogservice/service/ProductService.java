package com.marcobikes.productcatalogservice.service;

import com.marcobikes.productcatalogservice.dto.ProductDTO;
import com.marcobikes.productcatalogservice.dto.ProductOptionDTO;
import com.marcobikes.productcatalogservice.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public ProductDTO getProductById(UUID id);

    public List<ProductDTO> getAllProducts();

    public ProductDTO addProduct(ProductDTO product);

    public List<ProductOptionDTO> getProductOptions(UUID productId);

    public Double getBasePrice(UUID productId);
}
