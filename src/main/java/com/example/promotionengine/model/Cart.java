package com.example.promotionengine.model;

import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart(List<Product> products) {
        super();
        this.products = products;
    }

    public Cart() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
