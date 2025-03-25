package com.marcobikes.productcatalogservice.mapper;

import com.marcobikes.productcatalogservice.dto.OptionValueDTO;
import com.marcobikes.productcatalogservice.dto.ProductDTO;
import com.marcobikes.productcatalogservice.dto.ProductOptionDTO;
import com.marcobikes.productcatalogservice.model.OptionValue;
import com.marcobikes.productcatalogservice.model.Product;
import com.marcobikes.productcatalogservice.model.ProductOption;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);

    ProductOptionDTO toDTO(ProductOption option);
    ProductOption toEntity(ProductOptionDTO optionDTO);

    OptionValueDTO toDTO(OptionValue optionValue);
    OptionValue toEntity(OptionValueDTO optionValueDTO);

}
