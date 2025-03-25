package com.marcobikes.productcatalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOptionDTO {
    private UUID id;
    private String name;
    private List<OptionValueDTO> values;
}
