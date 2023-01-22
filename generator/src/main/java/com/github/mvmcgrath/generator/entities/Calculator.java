package com.github.mvmcgrath.generator.entities;

public class Calculator {
    public int additionMethod(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplyBy2(int num) {
        return additionMethod(num, num);
    }
}
