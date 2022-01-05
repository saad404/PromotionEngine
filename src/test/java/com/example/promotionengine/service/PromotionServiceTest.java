package com.example.promotionengine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.promotionengine.model.Product;
import com.example.promotionengine.model.Promotion;
import com.example.promotionengine.model.PromotionName;
import com.example.promotionengine.model.SKU;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class PromotionServiceTest {
    PromotionService service = new PromotionServiceImpl();

    @Test
    public void calculatePromotionTest() {
        Product prodA = new Product(SKU.A, "Product A is added", new BigDecimal(50));
        Product prodB = new Product(SKU.B, "Product B is added", BigDecimal.valueOf(30));
        Product prodC = new Product(SKU.C, "Product C is added", BigDecimal.valueOf(20));
        List<Promotion> promotions = Arrays.asList(new Promotion(true, PromotionName.THREEA,
                BigDecimal.valueOf(130)));
        assertEquals(new BigDecimal(100), service.calculatePromotion(Arrays.asList(prodA, prodB, prodC),
                promotions));
    }
}
