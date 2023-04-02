package com.example.ReactiveSpringDemo.lesson_1.repositories;

import com.example.ReactiveSpringDemo.lesson_1.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository

// we must extend a "reactive" spring data contract!
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

    // in the inheritance tree, the reactive crud repo extends repository directly
    // so this IS NOT A JPA repository ... it's TOTALLY different!




}
