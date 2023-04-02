package com.example.ReactiveSpringDemo.first;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository2 extends ReactiveCrudRepository<Product2, Long> {
}
