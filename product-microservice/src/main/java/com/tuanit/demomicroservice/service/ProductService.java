package com.tuanit.demomicroservice.service;

import com.tuanit.demomicroservice.dto.ProductRequest;
import com.tuanit.demomicroservice.dto.ProductResponse;
import com.tuanit.demomicroservice.model.Product;
import com.tuanit.demomicroservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved!", product.getId());

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public ProductResponse getOne(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product not found"));

        return mapToProductResponse(product);
    }
}
