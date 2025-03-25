package com.marcobikes.productcatalogservice.repository;

import com.marcobikes.productcatalogservice.model.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, UUID> {
    List<ProductOption> findByProductId(UUID productId);
}
