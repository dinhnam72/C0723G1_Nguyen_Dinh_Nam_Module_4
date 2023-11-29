package com.example.bt.service;

import com.example.bt.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
   List<Product> findAll();
   Product findById(long id);
}
