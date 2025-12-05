package org.example.productcatalogservice.services;

import org.example.productcatalogservice.clients.ProductClient;
import org.example.productcatalogservice.clients.amazon.AmazonProductClient;
import org.example.productcatalogservice.clients.fakestore.FakeStoreProductClient;
import org.example.productcatalogservice.dtos.ProductRequestDto;
import org.example.productcatalogservice.dtos.ProductResponseDto;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final ProductClient activeClient;

    public ProductServiceImpl(
            FakeStoreProductClient fakeStoreProductClient,
            AmazonProductClient amazonProductClient,
            @Value("${product.provider}") String provider
    ) {
        if ("amazon".equalsIgnoreCase(provider)) {
            this.activeClient = amazonProductClient;
        } else {
            this.activeClient = fakeStoreProductClient;
        }
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return activeClient.getProductById(id);
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        return activeClient.getAllProduct();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        return activeClient.createProduct(productRequestDto);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        return activeClient.updateProduct(id, productRequestDto);
    }

    @Override
    public void deleteProduct(Long id) {
        activeClient.deleteProduct(id);
    }
}
