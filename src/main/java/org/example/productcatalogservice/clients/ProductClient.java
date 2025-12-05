package org.example.productcatalogservice.clients;

import org.example.productcatalogservice.dtos.ProductRequestDto;
import org.example.productcatalogservice.dtos.ProductResponseDto;

import java.util.List;

public interface ProductClient {
    ProductResponseDto getProductById(Long id);
    List<ProductResponseDto> getAllProduct();
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);
    void deleteProduct(Long id);
}
