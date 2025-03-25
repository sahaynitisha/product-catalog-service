package com.marcobikes.productcatalogservice.service;

import com.marcobikes.productcatalogservice.dto.OptionValueDTO;
import com.marcobikes.productcatalogservice.dto.ProductDTO;
import com.marcobikes.productcatalogservice.dto.ProductOptionDTO;
import com.marcobikes.productcatalogservice.mapper.ProductMapper;
import com.marcobikes.productcatalogservice.model.OptionValue;
import com.marcobikes.productcatalogservice.model.Product;
import com.marcobikes.productcatalogservice.model.ProductOption;
import com.marcobikes.productcatalogservice.repository.OptionValueRepository;
import com.marcobikes.productcatalogservice.repository.ProductOptionRepository;
import com.marcobikes.productcatalogservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductOptionRepository productOptionRepository;

    @Autowired
    private OptionValueRepository optionValueRepository;

    @Autowired
    private ProductMapper productMapper; //Spring Injects the Mapper



    @Override
    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        // Step 1: Convert the DTO to an entity
        Product product = productMapper.toEntity(productDTO);
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        // Step 2: Process the options and option values
        if (productDTO.getOptions() != null) {
            for (ProductOptionDTO optionDTO : productDTO.getOptions()) {
                ProductOption option = productMapper.toEntity(optionDTO);
                option.setProduct(product); // Set the product for the option
                // Process each option value
                if (optionDTO.getValues() != null) {
                    for (OptionValueDTO valueDTO : optionDTO.getValues()) {
                        OptionValue optionValue = productMapper.toEntity(valueDTO);
                        optionValue.setOption(option); // Set the option for the value
                        option.getValues().add(optionValue); // Add value to option
                    }
                }

                // Add option to product's options list
                product.getProductOptions().add(option);
            }
        }

        // Step 3: Save the product and its related entities
        Product savedProduct = productRepository.save(product);

        // Step 4: Return the saved product as DTO
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public List<ProductOptionDTO> getProductOptions(UUID productId) {
        List<ProductOption> options = productOptionRepository.findByProductId(productId);
        return options.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Double getBasePrice(UUID productId) {
        return productRepository.findById(productId)
                .map(Product::getBasePrice)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
