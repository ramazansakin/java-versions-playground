package org.example.java23;

public class PrimitivePatternExample {

    public static void main(String[] args) {
        Object value = 42;

        if (value instanceof int i) {
            System.out.println("Integer value: " + i);
        } else {
            System.out.println("Not an integer.");
        }
    }

}
