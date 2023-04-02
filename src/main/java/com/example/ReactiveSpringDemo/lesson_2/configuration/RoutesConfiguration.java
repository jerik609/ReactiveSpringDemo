package com.example.ReactiveSpringDemo.lesson_2.configuration;

import com.example.ReactiveSpringDemo.lesson_1.model.Product;
import com.example.ReactiveSpringDemo.lesson_2.handlers.ProductHandler;
import com.example.ReactiveSpringDemo.lesson_2.services.ProductService2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class RoutesConfiguration {

    private final ProductHandler productHandler;

    @Bean
    public RouterFunction<ServerResponse> productRoutes() {
        return route()
                // more routes can be added here
                .GET("/product2", productHandler::getAll)
                .build();


    }

}
