package com.github.mvmcgrath;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {
    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void additionTest() {
        int result = calculator.additionMethod(5,5);
        assertEquals(result, 10);
    }

    @Test
    public void multiplyTest() {
        int result = calculator.multiplyBy2(5);
        assertEquals(result, 10);
    }
}
