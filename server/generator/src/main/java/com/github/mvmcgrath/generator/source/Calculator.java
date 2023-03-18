package com.github.mvmcgrath.generator.source;

public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplyBy2(int num) {
        return addition(num, num);
    }
}