package com.rasmi.salestest;


import com.rasmi.salestest.model.Basket;
import com.rasmi.salestest.utils.FakeDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * a testing class that uses {@link com.rasmi.salestest.utils.FakeDataProvider} to
 * verify values
 */
@SpringBootTest
public class BasketTests extends Assert {

    @Test
    public void testTotalPrice() {
        // Total: 29.83
        Basket firstBasket = FakeDataProvider.getInstance().getBaskets().get(0);
        assertEquals(firstBasket.getTotal(), 29.83, 0);
    }

    @Test
    public void testTotalTaxes() {
        // Sales Taxes: 7.65
        Basket secondBasket = FakeDataProvider.getInstance().getBaskets().get(1);
        assertEquals(secondBasket.getTotalTaxes(), 7.65, 0);
    }
}
