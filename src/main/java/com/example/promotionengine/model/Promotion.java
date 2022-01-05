package com.example.promotionengine.model;

import java.math.BigDecimal;

public class Promotion {

    private boolean active;
    private PromotionName promoName;
    private BigDecimal promoPrice;

    public Promotion() {

    }

    public Promotion(boolean active, PromotionName promoName, BigDecimal promoPrice) {
        super();
        this.active = active;
        this.promoName = promoName;
        this.promoPrice = promoPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PromotionName getPromoName() {
        return promoName;
    }

    public void setPromoName(PromotionName promoName) {
        this.promoName = promoName;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }
}
