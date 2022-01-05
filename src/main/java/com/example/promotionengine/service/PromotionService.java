package com.example.promotionengine.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.promotionengine.model.Product;

public interface PromotionService {

    BigDecimal calculatePromotion(List<Product> products);
}
