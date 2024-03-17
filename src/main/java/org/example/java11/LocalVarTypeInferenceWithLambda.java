package org.example.java11;

import java.util.function.BiFunction;

public class LocalVarTypeInferenceWithLambda {

    public static void main(String[] args) {
        // Before Java 11
        BiFunction<Integer, Integer, Integer> addFunction = (Integer a, Integer b) -> a + b;
        int result1 = addFunction.apply(10, 5);
        System.out.println("Result 1: " + result1);

        // With Java 11's var syntax
        BiFunction<Integer, Integer, Integer> subtractFunction = (var a, var b) -> a - b;
        int result2 = subtractFunction.apply(10, 5);
        System.out.println("Result 2: " + result2);
    }

}
