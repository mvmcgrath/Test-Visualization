package com.github.mvmcgrath.generator.source;

import com.github.mvmcgrath.generator.source.Abacus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbacusTest {
	@Test
	public void abacusCanCount() {
		Abacus classUnderTest = new Abacus();
		assertEquals(2, classUnderTest.count(1));
	}

	@Test
	public void abacusCanDoubleCount() {
		Abacus classUnderTest = new Abacus();
		assertEquals(4, classUnderTest.countDouble(2));
	}
}