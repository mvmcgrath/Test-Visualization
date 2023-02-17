package com.github.mvmcgrath.generator.source;

public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplyBy2(int num) {
        return addition(num, num);
    }

    public int multiplyBy2IfEvenOr9(int num) {
        if (num % 2 == 0 || num == 9) {
            return multiplyBy2(num);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().addition(5,5));
    }
}
