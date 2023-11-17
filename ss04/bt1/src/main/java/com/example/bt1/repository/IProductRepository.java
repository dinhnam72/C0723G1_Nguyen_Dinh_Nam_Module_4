package com.example.bt1.repository;

import com.example.bt1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product checkById(int id);
    void update(Product product);
    void remove(int id);
    List<Product> searchByName(String name);
}
