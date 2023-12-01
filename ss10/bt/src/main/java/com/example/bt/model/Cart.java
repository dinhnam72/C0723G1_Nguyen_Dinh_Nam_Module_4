package com.example.bt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Map<Product,Integer> products = new HashMap<>();
//    private boolean checkItemInCart(Product product){
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            if(entry.getKey().getId()==(product.getId())){
//                return true;
//            }
//        }
//        return false;
//    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId()==(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!products.containsKey(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void removeProduct(Product product){
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry.getValue()==0){
            products.replace(itemEntry.getKey(),0);
        }else {
            Integer newQuantity = itemEntry.getValue() - 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public int countProductQuantity(){
        int productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public int countItemQuantity(){
        int count = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getValue()!=0){
                count++;
            }
        }
        return count;
    }

    public float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
