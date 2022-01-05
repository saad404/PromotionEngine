package com.example.promotionengine.model;

public enum SKU {
    A(50), B(30), C(20), D(15);

    private final int value;

    SKU(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
