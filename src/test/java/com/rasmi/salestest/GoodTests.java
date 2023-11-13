package com.rasmi.salestest;

import com.rasmi.salestest.enums.GoodType;
import com.rasmi.salestest.model.Good;
import com.rasmi.salestest.utils.FakeDataProvider;
import com.rasmi.salestest.utils.GoodsFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * a testing class that uses {@link com.rasmi.salestest.utils.FakeDataProvider} to
 * verify values
 */
@SpringBootTest
public class GoodTests extends Assert {

    private final GoodsFactory factory = new GoodsFactory();

    @Test
    public void testTotalPrice() {
        // 1 music CD a t 14.99 => totalPrice = 16.49
        Good firstElement = FakeDataProvider.getInstance().getBaskets().get(0).getGoods().get(1);
        assertEquals(firstElement.totalPrice(), 16.49, 0);
    }

    @Test
    public void testTotalPriceDeltaZero() {
        // 1 music CD a t 14.99 => totalPrice = 16.49
        Good firstElement = FakeDataProvider.getInstance().getBaskets().get(0).getGoods().get(1);
        assertFalse(firstElement.totalPrice() - 16.49 != 0);
    }

    @Test
    public void testTaxAmount() {
        // 1 music CD a t 14.99 => taxAmount = 1.50
        Good firstElement = FakeDataProvider.getInstance().getBaskets().get(0).getGoods().get(1);
        assertEquals(firstElement.taxAmount(), 1.5, 0);
    }

    @Test
    public void testTaxAmountDeltaZero() {
        // 1 music CD a t 14.99 => taxAmount = 1.50
        Good firstElement = FakeDataProvider.getInstance().getBaskets().get(0).getGoods().get(1);
        assertFalse(firstElement.taxAmount() - 1.5 != 0);
    }

    @Test
    public void testTaxImportDutyExempt() {
        // imported product tax = 0.05
        Good good = new Good();
        good.setImported(false);
        assertEquals(good.importDuty(), 0, 0);
    }

}
