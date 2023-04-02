package com.example.ReactiveSpringDemo.lesson_1.model;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Product {

    // mandatory, one must be an "id"
    @Id
    private long id;

    private String name;

}
