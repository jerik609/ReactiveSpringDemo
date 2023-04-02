# Reactive Web Application

- https://www.youtube.com/live/1XaHqhAA5Sw?feature=share

This is in contrast to the standard "servlet" web application - those using the "DispatcherServlet", which directs the calls to the controller.

Reactive does not use tomcat, but the netty server, which is a reactive server implementation, this one will be run in background (where tomcat was run previously).

Tomcat knows how to implement servlets, but cannot handle the data in a reactive way.

Netty is considered standard for reactive web applications - it knows how to handle data reactively.

Another problem e.g. with postman - it does not know how to work reactively. So we need to use chrome to see the data appear one by one.

Both client and server must be reactive, not just one of them.

Reactive is not a silver bullet.

## Endpoints

- app: http://localhost:8080/product
- h2 console:  http://localhost:8082/

## Data

```
create table product;
alter table product add column id integer unique;
alter table product add column name varchar(255);

insert into product values (1, 'Beer');
insert into product values (2, 'Chocolate');
insert into product values (3, 'Apples');
```

## Threads

Profiling is a bit complicated - since various threads can be dealing with the data as they flow through the application.

