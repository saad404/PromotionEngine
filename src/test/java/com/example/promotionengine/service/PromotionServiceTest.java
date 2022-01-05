package com.example.promotionengine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.promotionengine.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PromotionServiceTest {
    PromotionService service = new PromotionServiceImpl();
    Product prodA = new Product(SKU.A, "Product A is added", BigDecimal.valueOf(50));
    Product prodB = new Product(SKU.B, "Product B is added", BigDecimal.valueOf(30));
    Product prodC = new Product(SKU.C, "Product C is added", BigDecimal.valueOf(20));

    @Test
    public void calculatePromotionWithPromotionAppliedScenarioATest() {
        List<Promotion> promotions = Arrays.asList(new Promotion(true, PromotionName.THREEA,
                BigDecimal.valueOf(130)));
        List<Product> products = Arrays.asList(prodA, prodB, prodC);
        Cart cart = new Cart(products);
        assertEquals(new BigDecimal(100), service.calculateFinalCartPrice(cart, promotions));
    }

    @Test
    public void calculateFinalPriceAfterSatisfyingPromotionScenarioBTest() {
        //5 A's, 5 B's, 1 C
        List<Product> products = Arrays.asList(prodA, prodA, prodA, prodA, prodA, prodB, prodB, prodB, prodB, prodB,
                prodC);
        Cart cart = new Cart(products);
        List<Promotion> promotions = Arrays.asList(new Promotion(true, PromotionName.THREEA,
                BigDecimal.valueOf(130)), new Promotion(true, PromotionName.TWOB, BigDecimal.valueOf(45)),
                new Promotion(true, PromotionName.CD, BigDecimal.valueOf(30)));
        assertEquals(BigDecimal.valueOf(370), service.calculateFinalCartPrice(cart, promotions));
    }

    @Test
    public void calculateFinalPriceWithoutPromotionTest() {
        List<Product> products = Arrays.asList(prodA, prodB, prodC);
        Cart cart = new Cart(products);
        assertEquals(BigDecimal.valueOf(100), service.calculateFinalCartPrice(cart, null));
    }
}
