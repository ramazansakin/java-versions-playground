package org.example.java19;

public class PatternMatchingExample {

    static void printValue(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case null -> System.out.println("Null value");
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        printValue(42);
        printValue("Java 19");
        printValue(null);
    }

}

