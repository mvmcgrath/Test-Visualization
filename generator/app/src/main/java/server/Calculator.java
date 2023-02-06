package server;

public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplyBy2(int num) {
        return addition(num, num);
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().addition(5,5));
    }
}
