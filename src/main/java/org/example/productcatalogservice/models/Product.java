package org.example.productcatalogservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.productcatalogservice.models.BaseModel;
import org.example.productcatalogservice.models.Category;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseModel {

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Product description is required")
    @Column(nullable = false, length = 1000)
    private String description;

    private String imageUrl; // not mandatory

    @Positive(message = "Price must be greater than zero")
    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;  // This will be fully implemented in Commit 6

    @Column(nullable = false)
    private Boolean isPrimeSaleSpecific;
}
