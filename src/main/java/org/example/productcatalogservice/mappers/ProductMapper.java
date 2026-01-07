package org.example.productcatalogservice.mappers;

import org.example.productcatalogservice.dtos.ProductRequestDto;
import org.example.productcatalogservice.dtos.ProductResponseDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;

public class ProductMapper {

    private ProductMapper() {
        // utility class
    }

    public static Product toEntity(ProductRequestDto dto, Category category) {
        if (dto == null) return null;

        Product product = new Product();
        product.setName(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getThumbnail());
        product.setCategory(category);

        // default business value
        product.setIsPrimeSaleSpecific(false);

        return product;
    }

    public static ProductResponseDto toResponseDto(Product product) {
        if (product == null) return null;

        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setTitle(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setThumbnail(product.getImageUrl());

        return dto;
    }
}
