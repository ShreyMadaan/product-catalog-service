package org.example.productcatalogservice.mappers;

import org.example.productcatalogservice.dtos.CategoryRequestDto;
import org.example.productcatalogservice.dtos.CategoryResponseDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    private CategoryMapper() {
        // utility class
    }

    public static Category toEntity(CategoryRequestDto dto) {
        if (dto == null) return null;

        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public static CategoryResponseDto toResponseDto(Category category) {
        if (category == null) return null;

        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

        List<Product> products = category.getProducts();
        if (products != null) {
            dto.setProductIds(
                    products.stream()
                            .map(Product::getId)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
