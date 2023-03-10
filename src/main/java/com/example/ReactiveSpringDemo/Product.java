package com.example.ReactiveSpringDemo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    @Id
    private long id;

    private String name;

}
