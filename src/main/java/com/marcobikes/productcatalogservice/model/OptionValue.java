package com.marcobikes.productcatalogservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Table(name = "option_values")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // Prevents circular reference
public class OptionValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String valueName;
    private double extraCost;

    @ManyToOne
    @JoinColumn(name = "option_id") //foreign key to ProductOption
    private ProductOption option;
}
