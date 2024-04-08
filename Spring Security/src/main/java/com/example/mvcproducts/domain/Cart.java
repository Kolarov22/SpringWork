package com.example.mvcproducts.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Cart {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
//    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private Set<Product> products = new HashSet<Product>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}