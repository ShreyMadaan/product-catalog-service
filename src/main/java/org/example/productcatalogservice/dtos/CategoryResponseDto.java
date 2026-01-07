package org.example.productcatalogservice.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;

    private List<Long> productIds;
}
