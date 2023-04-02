package com.example.ReactiveSpringDemo.lesson_2.services;

import com.example.ReactiveSpringDemo.lesson_1.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService2 {

    // What is Flux? - a pipe through which events flow, like a list, but
    //  instead of being static, here data flow constantly
    //  it's more complex than that of course

    // backpressure in reactive? not for kafka style (maybe), but what about
    // rabbitmq

    // delay will represent processing which takes some time
    public Flux<Product> getAll() {

        // imagine these come from a DB
        final var beer = Product.builder().id(1).name("Beer").build();
        final var chocolate = Product.builder().id(2).name("Beer").build();
        final var apple = Product.builder().id(3).name("Apple").build();
        final var productArr = new Product[]{beer, chocolate, apple};

        // simulate something happens with each product (otherwise everything would happen too fast and seem non-reactive)
        return Flux.fromArray(productArr)
                .delayElements(Duration.ofSeconds(3));

        // now we could expose this via a rest controller (standard "non-reactive" spring way)
    }

}
