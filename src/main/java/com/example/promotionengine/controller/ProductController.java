package com.example.promotionengine.controller;

import com.example.promotionengine.exception.ProductIsEmptyException;
import com.example.promotionengine.model.Cart;
import com.example.promotionengine.model.Product;
import com.example.promotionengine.model.Promotion;
import com.example.promotionengine.service.PromotionService;
import com.example.promotionengine.service.PromotionServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class ProductController {

    Cart cart = new Cart();
    PromotionService service = new PromotionServiceImpl();

    public Cart addProductToCart(List<Product> product) throws ProductIsEmptyException {
        Cart cart = null;
        if (product != null) {
            cart = new Cart(product);
        } else {
            throw new ProductIsEmptyException("Product cannot be empty");
        }
        return cart;
    }

    public void finalCheckoutWithPromotion(List<Promotion> promotions) {
        BigDecimal finalPrice = service.calculateFinalCartPrice(cart, promotions);
        System.out.println("Final Cost: " + finalPrice);
    }
}
