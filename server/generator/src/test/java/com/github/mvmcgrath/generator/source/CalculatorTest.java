package com.github.mvmcgrath.generator.source;

import com.github.mvmcgrath.generator.source.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test public void calculatorCanAdd() {
        Calculator classUnderTest = new Calculator();
        assertEquals(10, classUnderTest.addition(5,5));
    }

    @Test public void calculatorCanMultiplyBy2() {
        Calculator classUnderTest = new Calculator();
        assertEquals(10, classUnderTest.multiplyBy2(4));
    }
}