package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Product;
import java.util.List;

public interface ProductRepository{
    List<Product> getProducts();
    Product addProduct(Product product);
    Product getProductById(int productId);
}