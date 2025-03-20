package org.example.java21;

// Use type patterns inside switch without casting.
// Cleaner, more powerful, and eliminates unnecessary casting.
public class PatternMatchingExample {

    static void process(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s when !s.isEmpty() -> System.out.println("Non-empty String: " + s);
            case null -> System.out.println("It's null!");
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        process(42);
        process("Java 21");
        process(null);
    }

}

