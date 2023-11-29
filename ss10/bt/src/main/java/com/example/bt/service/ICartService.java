package com.example.bt.service;

import com.example.bt.model.Product;

import java.util.Map;

public interface ICartService {
    boolean checkItemInCart(Product product);
    Map.Entry<Product, Integer> selectItemInCart(Product product);
    void addProduct(Product product);
    int countProductQuantity();
    int countItemQuantity();
    float countTotalPayment();
}
