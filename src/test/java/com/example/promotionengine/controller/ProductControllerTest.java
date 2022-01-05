package com.example.promotionengine.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.promotionengine.exception.ProductIsEmptyException;
import com.example.promotionengine.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductControllerTest {

    ProductController controller = new ProductController();

    @Test
    public void addToCartOneProductTest() throws ProductIsEmptyException {
        Product prodA = new Product(SKU.A, "Product A is added", BigDecimal.valueOf(50));
        List<Product> products = Arrays.asList(prodA);
        Cart cart = controller.addProductToCart(products);
        List<Cart> carts = Arrays.asList(cart);
        assertEquals(1, carts.size());
    }

    @Test
    public void addToCart3ProductTest() throws ProductIsEmptyException {
        Product prodA = new Product(SKU.A, "Product A is added", BigDecimal.valueOf(50));
        Product prodB = new Product(SKU.B, "Product B is added", BigDecimal.valueOf(30));
        Product prodC = new Product(SKU.C, "Product C is added", BigDecimal.valueOf(20));

        List<Product> products = Arrays.asList(prodA, prodB, prodC);
        Cart cart = controller.addProductToCart(products);
        assertEquals(3, cart.getProducts().size());
    }
}
