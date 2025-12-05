package org.example.productcatalogservice.dtos;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String image;
}
