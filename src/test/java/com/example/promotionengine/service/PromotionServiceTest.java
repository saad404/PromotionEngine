package com.example.promotionengine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.promotionengine.model.Product;
import org.junit.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class PromotionServiceTest {
    PromotionService service = new PromotionServiceImpl();

    @Test
    public void calculatePromotionTest() {
        Product prodA = new Product("A", "A product", new BigDecimal(50));
        assertEquals(new BigDecimal(50), service.calculatePromotion(Arrays.asList(prodA)));
    }
}
