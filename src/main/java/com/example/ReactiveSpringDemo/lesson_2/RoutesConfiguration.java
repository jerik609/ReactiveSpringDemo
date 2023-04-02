package com.example.ReactiveSpringDemo.lesson_2;

import com.example.ReactiveSpringDemo.lesson_1.model.Product;
import com.example.ReactiveSpringDemo.lesson_2.services.ProductService2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class RoutesConfiguration {

    private final ProductService2 productService2;

    @Bean
    public RouterFunction<ServerResponse> productRoutes() {
        return route()
                .GET("/product2", request -> ok().body(productService2.getAll(), Product.class))
                // more routes can be added here
                .build();
    }
}
