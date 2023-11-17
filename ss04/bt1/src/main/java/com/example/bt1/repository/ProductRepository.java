package com.example.bt1.repository;

import com.example.bt1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList= new ArrayList<>();
    static {
        productList.add(new Product(1,"Sting",10000,"Pessi Việt Nam","Nước giải khát"));
        productList.add(new Product(2,"Redbull",15000,"Redbull Việt Nam","Nước giải khát"));
        productList.add(new Product(3,"Bánh sinh nhật",80000,"Cô bên đường","Đồ ăn "));
        productList.add(new Product(4,"Bánh tráng trộn",20000,"Hàng rong","Đồ ăn"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product checkById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return  productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()){
               productList.set(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.remove(i);
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product:productList){
            if (product.getName().contains(name)){
                products.add(product);
            }
        }
        return products;
    }
}
