package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model){
        List<Product> products = productService.findAll();
        List<Long> list_ids = new ArrayList<>();
        for (Product p : products)
        {
            list_ids.add(p.getId());
        }

        model.addAttribute("list_ids", list_ids);
        model.addAttribute("products", products);

        return "home";
    }
}
