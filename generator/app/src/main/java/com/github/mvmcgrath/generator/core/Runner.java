package com.github.mvmcgrath.generator.core;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();

        try {
            System.out.println("Waiting...");
            System.in.read();
            System.out.println("Full speed ahead!");

            Request request = Request.method(Class.forName("com.github.mvmcgrath.generator.tests.CalculatorTest"), "calculatorCanMultiplyBy2");
            Result result = junit.run(request);
            System.out.println(result.wasSuccessful());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
