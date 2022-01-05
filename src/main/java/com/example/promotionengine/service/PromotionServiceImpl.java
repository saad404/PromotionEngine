package com.example.promotionengine.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.promotionengine.model.Product;
import com.example.promotionengine.model.Promotion;

public class PromotionServiceImpl implements PromotionService {

    @Override
    public BigDecimal calculatePromotion(List<Product> products, List<Promotion> promotions) {
        BigDecimal price = products.stream().map(
                x -> x.getPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
        return price;
    }
}
