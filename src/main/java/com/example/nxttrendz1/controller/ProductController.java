package com.example.nxttrendz1.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.service.ProductJpaService;

@RestController
public class ProductController{
    @Autowired
    public ProductJpaService productJpaService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productJpaService.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productJpaService.addProduct(product);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId){
        return productJpaService.getProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("productId") int productId){
        return productJpaService.updateProduct(product,productId);
    }
}