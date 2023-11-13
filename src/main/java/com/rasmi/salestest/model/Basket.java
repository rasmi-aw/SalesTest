package com.rasmi.salestest.model;


import com.rasmi.salestest.utils.MathUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Basket {

    private List<Good> goods;

    public double getTotal() {
        double total = goods
                .stream()
                .map(Good::totalPrice)
                .reduce(0.0, Double::sum);
        return MathUtils.correctValue(total);
    }


    public double getTotalTaxes() {
        double taxes = goods
                .stream()
                .map(Good::taxAmount)
                .reduce(0.0, Double::sum);

        return MathUtils.scaleUp(taxes);
    }

    @Override
    public String toString() {
        return goods
                .stream()
                .map(Good::toString)
                .reduce("", (a, b) -> a + "\n" + b)
                + "\nSales Taxes: " + MathUtils.fixDisplay(getTotalTaxes())
                + " Total: " + MathUtils.fixDisplay(getTotal());
    }
}
