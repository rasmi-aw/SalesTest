package com.rasmi.salestest.enums;

public enum GoodType {
    FOOD("FOOD"), BOOK("BOOK"), MEDICAL("MEDICAL"), OTHER("OTHER");
    private final String value;

    GoodType(String typeStr) {
        this.value = typeStr.toUpperCase();
    }

    @Override
    public String toString() {
        return value;
    }
}
