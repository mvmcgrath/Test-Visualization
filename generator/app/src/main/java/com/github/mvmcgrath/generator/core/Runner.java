package com.github.mvmcgrath.generator.core;

import com.github.mvmcgrath.generator.source.Abacus;
import com.github.mvmcgrath.generator.source.Calculator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

public class Runner {
    //Extremely hacky
    public static void main(String[] args) throws Exception {
        //JUnitCore junit = new JUnitCore();

        System.out.println("Waiting...");
        System.in.read();
        System.out.println("Full speed ahead!");

        System.out.println(new Calculator().multiplyBy2(2));

        /*
        try {
            System.out.println("Waiting...");
            System.in.read();
            System.out.println("Full speed ahead!");

            System.out.println(new Abacus().countDouble(2));


            Request request = Request.method(Class.forName("com.github.mvmcgrath.generator.tests.AbacusTest"), "abacusCanDoubleCount");
            Result result = junit.run(request);
            System.out.println(result.wasSuccessful());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        */
    }
}
