package com.example.promotionengine.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.promotionengine.model.Product;

public class PromotionServiceImpl implements PromotionService {

    @Override
    public BigDecimal calculatePromotion(List<Product> products) {
        BigDecimal price = products.stream().map(
                x -> x.getPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
        return price;
    }
}
