package com.example.bt1.repository;

import com.example.bt1.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        TypedQuery query = entityManager.createQuery("from Product ", Product.class);
        productList = query.getResultList();
        return productList;
    }

    @Transactional
    @Override
    public void save(Product product) {
       entityManager.persist(product);
    }

    @Override
    public Product checkById(int id) {
        Product product= entityManager.find(Product.class,id);
        return product;
    }
    @Transactional
    @Override
    public void update(Product product) {
        Product productUpdate = checkById(product.getId());
        productUpdate.setName(product.getName());
        productUpdate.setProductType(product.getProductType());
        productUpdate.setManufacturer(product.getManufacturer());
        productUpdate.setPrice(product.getPrice());
        entityManager.merge(productUpdate);
    }
    @Transactional
    @Override
    public void remove(int id) {
        Product productRemove = checkById(id);
        entityManager.remove(productRemove);
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.name like :name ", Product.class);
        query.setParameter("name",name);
        return  query.getResultList();
    }
}

