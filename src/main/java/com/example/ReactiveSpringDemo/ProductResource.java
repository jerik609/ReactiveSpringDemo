package com.example.ReactiveSpringDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProduct() {
        return productService.getAllProducts();
    }

}
