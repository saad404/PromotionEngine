package com.example.promotionengine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.promotionengine.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class PromotionServiceTest {
    PromotionService service = new PromotionServiceImpl();
    Product prodA = new Product(SKU.A, "Product A is added", BigDecimal.valueOf(50));
    Product prodB = new Product(SKU.B, "Product B is added", BigDecimal.valueOf(30));
    Product prodC = new Product(SKU.C, "Product C is added", BigDecimal.valueOf(20));
    Product prodD = new Product(SKU.D, "Product D is added", BigDecimal.valueOf(15));

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

    @Test
    public void calculateFinalPriceWithoutCartTest() {
        assertThrows(
                NullPointerException.class,
                () -> {
                    service.calculateFinalCartPrice(null, null);
                });
    }

    @Test
    public void createPromo3ProdATest() {
        assertEquals(BigDecimal.valueOf(130), service.createPromotion(PromotionName.THREEA, SKU.A, 130)
                .getPromoPrice());
    }

    @Test
    public void calculateFinalPriceAfterPromotionScenarioBTest() {
        List<Product> products = Arrays.asList(prodA, prodA, prodA, prodA, prodA, prodB, prodB, prodB, prodB, prodB,
                prodC);
        Cart cart = new Cart(products);
        List<Promotion> promotions = Arrays.asList(new Promotion(true, PromotionName.THREEA, BigDecimal.
                valueOf(130)), new Promotion(true, PromotionName.TWOB, BigDecimal.valueOf(45)),
                new Promotion(true, PromotionName.CD, BigDecimal.valueOf(30)));
        assertEquals(BigDecimal.valueOf(370), service.calculateFinalCartPrice(cart, promotions));
    }

    @Test
    public void calculateFinalPriceAfterPromotionScenarioCTest() {
        List<Product> products = Arrays.asList(prodA, prodA, prodA, prodB, prodB, prodB, prodB, prodB, prodC, prodD);
        Cart cart = new Cart(products);
        List<Promotion> promotions = Arrays.asList(new Promotion(true, PromotionName.THREEA,
                BigDecimal.valueOf(130)), new Promotion(true, PromotionName.TWOB, BigDecimal.valueOf(45)),
                new Promotion(true, PromotionName.CD, BigDecimal.valueOf(30)));
        assertEquals(BigDecimal.valueOf(280), service.calculateFinalCartPrice(cart, promotions));
    }
}