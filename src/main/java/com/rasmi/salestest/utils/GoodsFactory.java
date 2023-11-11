package com.rasmi.salestest.utils;

import com.rasmi.salestest.enums.GoodType;
import com.rasmi.salestest.model.Good;
import com.rasmi.salestest.model.TaxExemptGood;
import lombok.NoArgsConstructor;

/**
 * @author Abdelouadoud Rasmi
 * Using factory design pattern to create objects based on good type
 */
@NoArgsConstructor
public class GoodsFactory {

    /**
     * @return a Good or TaxExemptGood object depending on goodType
     * @param name see {@link Good} class name attribute
     * @param price see {@link Good} class price attribute
     * @param quantity see {@link Good} class quantity attribute
     * @param imported see {@link Good} class imported attribute
     * @param type see {@link GoodType} enum, depending on this value this method returns
     * the appropriate type of object
     */
    public Good getGood(String name, Double price, int quantity, boolean imported, GoodType type) {
        if (type == null) {
            return null;
        } else if (type.equals(GoodType.OTHER)) {
            return new Good(name, price, quantity, type, imported);
        } else {
            return new TaxExemptGood(name, price, quantity, type, imported);
        }
    }
}
