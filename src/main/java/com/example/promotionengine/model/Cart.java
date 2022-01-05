package com.example.promotionengine.model;

import java.util.List;

/**
 * This is the Cart class where one can get the full list of products in the cart and also set them.
 * */

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
