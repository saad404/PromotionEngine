package com.example.promotionengine.model;

public enum PromotionName {
    THREEA(130), TWOB(45), CD(30);

    private int value;

    PromotionName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
