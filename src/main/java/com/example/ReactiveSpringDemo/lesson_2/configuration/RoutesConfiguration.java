package com.example.ReactiveSpringDemo.lesson_2.configuration;

import com.example.ReactiveSpringDemo.lesson_1.model.Product;
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

    private final ProductService2 productService2;

    @Bean
    public RouterFunction<ServerResponse> productRoutes() {
        return route()
                .GET("/product2", request -> ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM) // but in chrome it worked even without it, so chrome is probably able to handle this somehow properly by now?
                        // actually the content type changes the behavior
                        // where I'd see the json list slowly populating, with the "correct" content type, the data is arriving as text one-by-one
                        .body(productService2.getAll(), Product.class))
                // more routes can be added here
                .build();

        // what is the benefit?
        // - releasing resources when we're waiting (a thread)
        // - more responsive application ... deliver the values as they are ready, not waiting for all of them being ready
        // - making threads when they are waiting for something

        // @Async vs reactive - i.e. what really is spring's @Async? https://www.baeldung.com/spring-mvc-async-vs-webflux
        // the lecturer says it's not even comparable ^^^

        // ok, so now only reactive backpressure remains out of my open question

        // remember - reactive is NOT better in all circumstances, it depends on the case

    }

}
