package com.example.bt1.service;

import com.example.bt1.model.Product;
import com.example.bt1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product checkById(int id) {
        return productRepository.checkById(id);
    }

    @Override
    public void update(Product product) {
    productRepository.update(product);
    }

    @Override
    public void remove(int id) {
productRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
