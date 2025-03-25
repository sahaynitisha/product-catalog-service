package com.marcobikes.productcatalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String category;
    private Double basePrice;
    private String description;
    private Timestamp createdAt;
    private List<ProductOptionDTO> options;
}
