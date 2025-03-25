package com.marcobikes.productcatalogservice.repository;

import com.marcobikes.productcatalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.productOptions WHERE p.id = :id")
    Optional<Product> findByIdWithOptions(@Param("id") UUID id);
}
