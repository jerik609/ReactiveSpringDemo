The standard controller way is ok, but the reactive way is more functional. None of the approaches is ultimately good or bad.

## Here we will do two things:
- expose the routes in a reactive fashion
- and consume events from (reactive) routes

## What has to be done:
- we will simulate having a datasource
- we will use the Product from lesson 1

## What is the benefit or reactive??
- releasing resources when we're waiting (a thread)
- more responsive application ... deliver the values as they are ready, not waiting for all of them being ready
- making threads when they are waiting for something
- remember - reactive is NOT better in all circumstances, it depends on the case

## @Async vs reactive 
- i.e. what really is spring's @Async? https://www.baeldung.com/spring-mvc-async-vs-webflux
- the lecturer says it's not even comparable ^^^

## Reactive backpressure 
ok, so now only reactive backpressure remains out of my open question
