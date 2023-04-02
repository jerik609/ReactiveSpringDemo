package com.example.ReactiveSpringDemo.lesson_2.handlers;

import com.example.ReactiveSpringDemo.lesson_1.model.Product;
import com.example.ReactiveSpringDemo.lesson_2.services.ProductService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductService2 productService2;

    // server request is not used
    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ok()
                // but in chrome it worked even without specific media type,
                // so chrome is probably able to handle this somehow properly by now?
                // actually the content type changes the behavior
                // where I'd see the json list slowly populating, with the "correct" content type, the data is arriving as text one-by-one
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService2.getAll(), Product.class);
    }

}
