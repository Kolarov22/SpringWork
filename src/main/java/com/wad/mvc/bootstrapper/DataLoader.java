package com.wad.mvc.bootstrapper;

import com.wad.mvc.domain.Product;
import com.wad.mvc.domain.User;
import com.wad.mvc.repositories.ProductRepository;
import com.wad.mvc.repositories.UserRepository;
import com.wad.mvc.services.ProductService;
import com.wad.mvc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    public final UserService userService;
    public final ProductService productService;

    public DataLoader(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList(List.of(
                new User(28L, "Andrei", "andrei@yahoo.com"),
                new User(20L, "John", "john@outlook.com"),
                new User(19L, "Michael", "mike@gmail.com"))
        );

        for ( User u : users ){
            this.userService.save(u);
        }

        List<Product> products = new ArrayList(List.of(
                new Product(13L, "ice cream", 200L, "food"),
                new Product(15L, "bike", 5000L, "transportation"),
                new Product(19L, "car", 10000L, "transportation"))
        );

        for ( Product p : products){
            this.productService.save(p);
        }

    }
}
