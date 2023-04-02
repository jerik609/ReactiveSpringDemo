package com.example.ReactiveSpringDemo.second.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    // mandatory, one must be an "id"
    @Id
    private long id;

    private String name;

}
