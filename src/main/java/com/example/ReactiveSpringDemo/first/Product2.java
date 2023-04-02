package com.example.ReactiveSpringDemo.first;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
// no entity annotation, because that's an ORM annotation
public class Product2 {

    // even this ID is not a JPA ID, it's "data" annotation
    @Id
    private long id;

    private String name;

}
