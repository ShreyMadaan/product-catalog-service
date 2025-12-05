package org.example.productcatalogservice.clients.fakestore;

import org.example.productcatalogservice.clients.ProductClient;
import org.example.productcatalogservice.dtos.ProductRequestDto;
import org.example.productcatalogservice.dtos.ProductResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductClient implements ProductClient {
    private final RestTemplate restTemplate;

    @Value("${fakestore.api.base-url}")
    private String fakeStoreBaseUrl;

    public FakeStoreProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return restTemplate.getForObject(fakeStoreBaseUrl + "/products/" + id, ProductResponseDto.class);
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        ProductResponseDto[] products = restTemplate.getForObject(fakeStoreBaseUrl + "/products", ProductResponseDto[].class);
        return Arrays.asList(products);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        return restTemplate.postForObject(fakeStoreBaseUrl + "/products", productRequestDto, ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        String url = fakeStoreBaseUrl + "/products/" + id;
        restTemplate.put(url, productRequestDto);
        return getProductById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(fakeStoreBaseUrl + "/products/" + id);
    }
}
