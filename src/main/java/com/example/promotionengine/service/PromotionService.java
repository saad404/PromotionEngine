package com.example.promotionengine.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.promotionengine.model.Cart;
import com.example.promotionengine.model.Promotion;
import com.example.promotionengine.model.PromotionName;
import com.example.promotionengine.model.SKU;

public interface PromotionService {

    public BigDecimal calculateFinalCartPrice(Cart cart, List<Promotion> promotions);
    public Promotion createPromotion(PromotionName promotionName, SKU sku, int percent);
}
