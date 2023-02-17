package com.github.mvmcgrath.generator.source;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbacusTest {
    @Test
    public void abacusCanCount() {
        Abacus classUnderTest = new Abacus();
        assertEquals(2, classUnderTest.count(1));
    }
}
