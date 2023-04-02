package com.example.ReactiveSpringDemo.first;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ProductResource2 {

    private final ProductService2 productService;

    @GetMapping(value = "/first_product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product2> getProduct() {
        return productService.getAllProducts();
    }

}
