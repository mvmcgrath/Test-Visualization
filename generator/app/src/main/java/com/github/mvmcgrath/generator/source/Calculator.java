package com.github.mvmcgrath.generator.source;

public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplyBy2(int num) {
        return addition(num, num);
    }

    public int multiplyBy2IfEvenOr9(int num) {
        int returnValue = -1;
        for (int i = 0; i < 10; i++) {
            System.out.println("Go");
        }
        return returnValue;
    }
}
