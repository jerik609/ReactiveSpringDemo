package com.example.ReactiveSpringDemo.first;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ProductService2 {

    private final ProductRepository2 productRepository;

    public Flux<Product2> getAllProducts() {
        return productRepository.findAll().delayElements(Duration.ofSeconds(3));
    }

}
