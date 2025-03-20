package org.example.java20;

public class SwitchPatternExample {

    static void process(Object obj) {
        switch (obj) {
            case Integer i when i > 0 -> System.out.println("Positive integer: " + i);
            case Integer i when i < 0 -> System.out.println("Negative integer: " + i);
            case String s when !s.isEmpty() -> System.out.println("Non-empty string: " + s);
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        process(42);
        process(-10);
        process("Java 20");
        process("");
    }
}
