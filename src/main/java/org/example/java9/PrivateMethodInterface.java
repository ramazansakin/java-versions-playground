package org.example.java9;

import java.util.function.IntBinaryOperator;

interface Calculator {
    default int add(int a, int b) {
        return performOperation(a, b, (x, y) -> x + y);
    }

    default int subtract(int a, int b) {
        return performOperation(a, b, (x, y) -> x - y);
    }

    private int performOperation(int a, int b, IntBinaryOperator operator) {
        // Common logic for performing operations
        return operator.applyAsInt(a, b);
    }
}

public class PrivateMethodInterface implements Calculator {

    public static void main(String[] args) {

        PrivateMethodInterface calculator = new PrivateMethodInterface();
        System.out.println("Addition: " + calculator.add(5, 3));
        System.out.println("Subtraction: " + calculator.subtract(5, 3));

    }

}
