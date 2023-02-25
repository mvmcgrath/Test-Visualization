package com.github.mvmcgrath.generator.source;

public class Abacus {
    public int count (int num) {
        return ++num;
    }

    public int countDouble(int num) {
        return new Calculator().multiplyBy2(num);
    }
}
