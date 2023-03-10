package com.example.ReactiveSpringDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> getAllProducts() {
        return productRepository.findAll().delayElements(Duration.ofSeconds(3));
    }

}
