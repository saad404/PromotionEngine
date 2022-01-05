package com.example.promotionengine.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.promotionengine.model.Cart;
import com.example.promotionengine.model.Promotion;

public interface PromotionService {

    BigDecimal calculateFinalCartPrice(Cart cart, List<Promotion> promotions);
}
