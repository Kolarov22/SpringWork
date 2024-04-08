package com.wad.mvc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
@Id
@GeneratedValue
    private Long id;
    private String name;
    private Long price;
    private String category;

    public Product(String name, Long price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
