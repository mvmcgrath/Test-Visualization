package com.github.mvmcgrath.generator.source;

public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplyBy2(int num) {
        return addition(num, num);
    }

    public int multiplyBy2IfEvenOr9(int num) {
        int ans;
        if (num % 2 == 0 || num == 9) {
            ans = 1;
        } else {
            ans = -1;
        }
        ans = 2;
        return ans;
    }
}
