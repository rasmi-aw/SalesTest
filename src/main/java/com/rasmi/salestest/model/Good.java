package com.rasmi.salestest.model;

import com.rasmi.salestest.enums.GoodType;
import com.rasmi.salestest.utils.MathUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Abdelouadoud Rasmi
 * This is the class representation of a Good (item)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private static final double IMPORT_DUTY = 0.05;

    private String name;
    private double price;
    private int quantity;
    private GoodType type;
    private boolean imported;

    /**
     * returns the tax rate, by default it's 10%,
     * subclasses need to override this method only to  change the default tax rate
     */
    public double taxRate() {
        return 0.1;
    }

    public double importDuty() {
        return (imported ? IMPORT_DUTY : 0);
    }


    /**
     * @return the final tax amount that should be paid
     */
    public double taxAmount() {
        return MathUtils.roundUp(quantity * price * (taxRate() + importDuty()));
    }

    /**
     * @return the total price including tax amount
     */
    public double totalPrice() {
        return MathUtils.roundUp(quantity * (price + taxAmount()));
    }

    @Override
    public String toString() {
        return quantity + (imported ? " imported " : " ") + name + ": " + MathUtils.fixDisplay(totalPrice());
    }
}
