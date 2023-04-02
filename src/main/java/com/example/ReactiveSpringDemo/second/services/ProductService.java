package com.example.ReactiveSpringDemo.second.services;

import com.example.ReactiveSpringDemo.second.model.Product;
import com.example.ReactiveSpringDemo.second.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

// reminder - instructs Spring to create a bean of this type in the spring context
// NOTE: it does not make sense to annotate interfaces with @Service, @Component -
//  since these cannot be instantiated by Spring - they are only interfaces, not actual classes we
//  can instantiate, thus the repository, which is an interface, will not be annotated
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // we're reactive (we have a reactive repository), thus not a stream, but a flux!
    // flux implements publisher
    public Flux<Product> getAllProducts() {
        return productRepository
                .findAll()
                // we will delay each element a bit to simulate an expensive operation
                .delayElements(Duration.ofSeconds(5));

        // thus the client will not get everything at once, or after 10s - it will get each record
        // one by one, in 5s intervals
    }

}
