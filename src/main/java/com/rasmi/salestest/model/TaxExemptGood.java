package com.rasmi.salestest.model;

import com.rasmi.salestest.enums.GoodType;

/**
 * @author Abdelouadoud Rasmi
 * This is the class representation of a tax exempted Goods, which means the taxt rate
 * will be 0 for all subclasses or objects, unless taxRate() was overidden
 */
public class TaxExemptGood extends Good {

    public TaxExemptGood(String name, Double price, int quantity, GoodType goodType, boolean imported) {
        super(name, price, quantity, goodType, imported);
    }

    /**
     * TaxExempt goods like Books, Medical items & Food has 0 tax rate
     */
    @Override
    public double taxRate() {
        return 0;
    }
}
