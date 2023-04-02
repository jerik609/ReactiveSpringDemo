package com.example.ReactiveSpringDemo.second.controllers;

import com.example.ReactiveSpringDemo.second.model.Product;
import com.example.ReactiveSpringDemo.second.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    // now, this needs a special configuration, otherwise it would be treated as
    // a non-reactive (re)source
    // this instructs the browser to expect a stream of data and represent it
    // as such
    // so the output should be "event stream" = produces MediaType.TEXT_EVENT_STREAM_VALUE
    // would this be necessary with Angular/JavaScript/React?
    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
