package com.codegym.dto;

import com.codegym.model.Product;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto,Integer> products) {
        this.products = products;
    }

    public Map<ProductDto,Integer> getProducts() {
        return products;
    }


    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }


    private boolean checkItemInCart(ProductDto product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDto product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }


    public void removeProduct(ProductDto product) {
        if (checkItemInCart(product)) {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(product);
            products.remove(itemEntry.getKey(), itemEntry.getValue());
        }
    }


    public void minusProduct(ProductDto product) {
        if (checkItemInCart(product)) {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(product);
            if (itemEntry.getValue() < 2) {
                removeProduct(product);
            } else {
                Integer newQuantity = itemEntry.getValue() - 1;
                products.replace(itemEntry.getKey(), newQuantity);
            }
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }



}
