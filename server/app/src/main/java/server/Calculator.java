/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package server;

public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().addition(5,5));
    }
}