package com.example.promotionengine.model;

/**
 * This is SKU enum class with the price as value.
 * */

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
