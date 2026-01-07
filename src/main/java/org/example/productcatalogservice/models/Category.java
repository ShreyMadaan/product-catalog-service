package org.example.productcatalogservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.productcatalogservice.models.Product;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseModel {

    @NotBlank(message = "Category name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Category description is required")
    @Column(nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
}
