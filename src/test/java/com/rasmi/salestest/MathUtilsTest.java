package com.rasmi.salestest;

import com.rasmi.salestest.utils.MathUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * a testing class for {@link MathUtils}
 */
@SpringBootTest
public class MathUtilsTest extends Assert {

    @Test
    public void testDecimalsDisplay() {
        // 1.2 => 1.20
        assertEquals(MathUtils.fixDisplay(1.2), "1.20");
    }

    @Test
    public void testDecimalsDisplayFalse() {
        // fixDisplay("1.3") != 1.3 since it gives 1.30
        assertNotEquals(MathUtils.fixDisplay(1.3), "1.3");
    }

    @Test
    public void testRoundUp() {
        // roundUp(1.83) = 1.85
        assertEquals(MathUtils.roundUp(1.83), 1.85, 0);
    }

    @Test
    public void testScaleUp() {
        // roundUp(1.89) = 1.9
        assertEquals(MathUtils.scaleUp(1.89), 1.9, 0.01);
    }

}
