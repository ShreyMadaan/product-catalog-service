package org.example.productcatalogservice.services;

import org.example.productcatalogservice.dtos.ProductRequestDto;
import org.example.productcatalogservice.dtos.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProduct();

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void deleteProduct(Long id);
}
