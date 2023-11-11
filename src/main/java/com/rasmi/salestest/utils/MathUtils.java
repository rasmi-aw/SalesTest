package com.rasmi.salestest.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author Abdelouadoud Rasmi
 * a helper class to round and format doubles, (Single responsibility)
 */
public class MathUtils {

    // private constructor to prevent objects creations
    private MathUtils() {
    }

    /** @return String representing a formatted number
     * Always Display 2 digits after the point by adding a zero to the right
     * if the fraction digits number is less than 2
     */
    public static String fixDisplay(double number) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        return format.format(number);
    }

    /**
     * rounds the second decimal up to 5
     */
    public static double roundUp(double number) {
        BigDecimal val = BigDecimal
                .valueOf(number)
                .setScale(2, RoundingMode.HALF_UP);
        number = val
                .doubleValue();
        // getting second fraction digit
        int frac = BigDecimal.valueOf(number).remainder(BigDecimal.ONE).setScale(2, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100)).intValue();
        int secondDigit = frac % 10;
        int replace = secondDigit > 0 ? Math.max(secondDigit, 5) : 0;
        replace = frac - secondDigit + replace;
        //
        val = val
                .subtract(BigDecimal.valueOf(frac / 100.00).setScale(2, RoundingMode.HALF_DOWN))
                .add(BigDecimal.valueOf(replace / 100.0).setScale(2, RoundingMode.HALF_DOWN));
        return val.doubleValue();
    }

    /**
     * corrects the second decimal value since it's inaccurate
     * (secondDecimal > 6 => 10 else keep the same value)
     */
    public static double scaleUp(double number) {
        int frac = BigDecimal.valueOf(number).movePointRight(2).intValue();
        int secondDigit = frac % 10;
        frac = frac - secondDigit;
        secondDigit = secondDigit > 5 ? 10 : secondDigit;
        frac = frac + secondDigit;
        return BigDecimal.valueOf(frac).movePointLeft(2).doubleValue();
    }
}
