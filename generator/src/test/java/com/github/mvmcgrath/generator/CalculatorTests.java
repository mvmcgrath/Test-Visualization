package com.github.mvmcgrath.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.mvmcgrath.generator.entities.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTests {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = new Calculator();
	}

	@Test
	void additionTest() {
		int result = calculator.additionMethod(5,5);
		assertEquals(result, 10);
	}

	@Test
	void multiplyTest() {
		int result = calculator.multiplyBy2(5);
		assertEquals(result, 10);
	}

}
