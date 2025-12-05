package org.example.productcatalogservice.dtos;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;

}
