package org.example.productcatalogservice.dtos;

import lombok.Data;

@Data
public class CategoryRequestDto {
    private String name;
    private String description;
}
