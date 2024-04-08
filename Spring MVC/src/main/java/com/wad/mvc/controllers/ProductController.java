package com.wad.mvc.controllers;
import com.wad.mvc.domain.Product;
import com.wad.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //-populate the model with the retrieved products!
    //-select the appropriate view (navigation)
    @GetMapping
    public String viewProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String showAddProductForm(Model model){
        model.addAttribute("product",new Product());
        return "addproducts";
    }

    @PostMapping("/new")
    public String addProduct(Product product){
        if(product.getId()==null)
            product.setId(new Random().nextLong());
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/form")
        public String getRequirements(){
            return "form";
        }

    @PostMapping("/form")
    public String postFilteredProducts(@RequestParam String category, @RequestParam Long price, Model model){
        model.addAttribute("filteredProducts", productService.filter(category, price));
        return "findResult";
    }
    }



