package com.wad.mvc.services;

import com.wad.mvc.domain.Product;
import com.wad.mvc.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    public final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public List<Product> filter(String category, Long price) {
        return productRepo.filter(category, price);
    }

}
