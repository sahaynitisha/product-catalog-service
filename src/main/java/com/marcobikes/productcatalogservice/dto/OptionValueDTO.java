package com.marcobikes.productcatalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionValueDTO {
    private UUID id;
    private String valueName;
    private double extraCost;
}
