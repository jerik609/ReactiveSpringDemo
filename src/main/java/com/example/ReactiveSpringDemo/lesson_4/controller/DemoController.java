package com.example.ReactiveSpringDemo.lesson_4.controller;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.IntStream;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {

        // simplest way of defining a flux
        final var f1 = Flux.just(1, 2, 3, 4, 5);

        // also from a stream
        final var f2 = Flux.fromStream(IntStream.range(1, 10).boxed());

        // from iterable
        final var f3 = Flux.fromIterable(Set.of(1, 2, 3, 4));

        // same for mono, e.g.
        final var m1 = Mono.just(999);

        // now let's add a subscriber to the mix
        final Flux<String> fx = Flux.create(
                emitter -> {
                    emitter.next("x");
                    emitter.next("y");
                    emitter.next("z");
                    emitter.complete();
                }
        );

        System.out.println("---- STARTED:");

        // this will not do anything on its own, we need a subscriber
        fx.doOnNext(n -> System.out.println("hello: " + n));
        // heed this little trap - if we now do this:
        //fx.subscribe(n -> System.out.println("hello: " + n));
        // we will not get the value "hello: x" printed twice
        // what's because a new flux is created, but the fx flux itself is not modified
        // probably this is not the proper explanation!

        // the flux is cold - it only emits, when there's a subscriber
        // the correct way to "chain" is this
        fx
                .doOnNext(value -> System.out.println("pass through: " + value))
                .subscribe(
                        value -> System.out.println("Teh value: " + value),
                        error -> System.out.println("Teh error: " + error),
                        () -> System.out.println("I'm done!"));

        // the simplest example
        Flux.just(1).subscribe(x -> System.out.println("ahoj: " + x));

        // most important thing is - THE SUBSCRIBER HAS TO REQUEST VALUES FROM THE PUBLISHER

        // let's have a better look at the subscriber and implement our own
        // now, when we execute this code, the only message we get, is the one from the subscribe method
        // why? well, the only thing that happens is, that we get a subscription
        // so to actually get some data, we need to use this subscription to
        // pull the data from the publisher
        Flux.just(1, 2, 3, 4, 5)
                .doOnNext(x -> {
                    if (x == 3)
                        throw new RuntimeException("boom!");
                })
                .onErrorContinue(
                        (throwable, o) -> System.out.println("tough luck baby")
                )

                .subscribe(new Subscriber<>() {

            private Subscription sub;

            @Override
            public void onSubscribe(Subscription s) {
                this.sub = s;
                System.out.println("subscribed: " + s);
                sub.request(1);
            }

            @Override
            public void onNext(Integer e) {
                System.out.println("on next: " + e);
                sub.request(1);
                // throwing an error here, will of course NOT BE HANDLED by
                // the subscriber's onError (which is meant for the publisher's errors)
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("on error: " + t);
            }

            @Override
            public void onComplete() {
                System.out.println("done!");
                sub.cancel();
            }
        });

        // if a subscriber does not request, he does not receive - that's a big difference
        // between the good-old streams API and the reactive is, that streams a push, but the
        // reactive is pull from subscriber

        // we can request multiple elements using the subscriber directly

        // backpressure - subscriber asks for the elements at a pace at which it can handle the
        // requests, when it's actually done, it can (will?) ask for more

        final Flux<Integer> fluxx = Flux.just(1, 2, 3, 4, 5)


                ;







        System.out.println("---- DONE.");
    }

    public void moo() {
        final var fx = Flux.create(
                emitter -> {
                    emitter.next("x");
                    emitter.next("y");
                    emitter.next("z");
                    emitter.complete();
                }
        );

        // but this is still logic on the publisher
        var x = fx.doOnNext(next -> {
            System.out.println("seeing " + next);
        }).doOnComplete(() -> System.out.println("done done done")).subscribe();

        System.out.println(x.isDisposed());

        x.dispose();

        System.out.println(x.isDisposed());

    }

}
