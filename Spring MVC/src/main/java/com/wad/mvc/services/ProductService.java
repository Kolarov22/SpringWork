package com.wad.mvc.services;

import com.wad.mvc.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product p);

    List<Product> filter(String cat, Long p);
}
