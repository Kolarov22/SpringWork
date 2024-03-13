package com.wad.mvc.services;

import com.wad.mvc.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList(List.of(
            new Product(13L, "ice cream", 200L, "food"),
            new Product(15L, "bike", 5000L, "transportation"),
            new Product(19L, "car", 10000L, "transportation"))
    );


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product p) {
        products.add(p);
    }

    @Override
    public List<Product> filter(String category, Long price) {
        List<Product> filteredProducts = products.stream().filter(p->p.getPrice() <= price && p.getCategory().equals(category)).collect(Collectors.toList());
        return filteredProducts;
    }

}
