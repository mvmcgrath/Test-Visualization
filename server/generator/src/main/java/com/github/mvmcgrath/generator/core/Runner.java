package com.github.mvmcgrath.generator.core;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

public class Runner {
    public static void main(String[] args) throws Exception {
        JUnitCore junit = new JUnitCore();
        Request request = Request.method(Class.forName("com.github.mvmcgrath.generator.tests.CalculatorTest"), "calculatorCanMultiplyBy2");
        Result result = junit.run(request);
        System.out.println(result.wasSuccessful());
    }
}
