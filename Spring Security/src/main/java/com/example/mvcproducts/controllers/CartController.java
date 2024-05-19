package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.*;
import com.example.mvcproducts.services.OrderService;
import com.example.mvcproducts.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SessionAttributes("cart")
@Controller
public class CartController {
    @Autowired
    ProductService productService;
    OrderService orderService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam Long pid, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(pid);
        cart.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        System.out.println(cart.getProducts());
        return "cart";
    }

    @PostMapping("cart/order")
    public String placeOrder(@ModelAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart", cart);
        ProductOrder order = new ProductOrder();
        var products = cart.getProducts();
        Stream<OrderLineItem> orderLineItemStream = products.stream().map(product -> new OrderLineItem(product.getId(), product, 1));
        order.setOrderLineItems(orderLineItemStream.collect(Collectors.toSet()));
        order.getOrderLineItems().stream().forEach((line)->System.out.println(line.toString()));
        return "redirect:/cart";

    }
}

