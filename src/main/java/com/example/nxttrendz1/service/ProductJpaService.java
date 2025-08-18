package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductRepository;
import com.example.nxttrendz1.repository.ProductJpaRepository;

@Service
public class ProductJpaService implements ProductRepository{
    @Autowired
    public ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> getProducts(){
        List<Product> products = productJpaRepository.findAll();
        return products;
    }

    @Override
    public Product addProduct(Product product){
       return productJpaRepository.save(product);
    }

    @Override
    public Product getProductById(int productId){
        try{
            Product product = productJpaRepository.findById(productId).get();
            return product;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
