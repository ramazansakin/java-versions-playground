package org.example.java10;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 1. Local-Variable Type Inference (var)
public class VarTypeInferenceExample {

    public static void main(String[] args) {
        // Before Java 10
        String oldMessage = "Hello Java 10";
        List<String> oldList = List.of("Java", "Kotlin", "Scala");
        Map<String, Integer> oldMap = Map.of("one", 1, "two", 2);

        // With Java 10 - using var for local variable type inference
        var message = "Hello Java 10";
        var list = List.of("Java", "Kotlin", "Scala");
        var map = Map.of("one", 1, "two", 2);

        // Works with loops
        for (var element : list) {
            System.out.println(element);
        }

        // Works with streams and complex types
        var upperCaseList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Works with anonymous classes too
        var comparator = new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        // Note: var cannot be used as:
        // - Method parameters
        // - Method return types
        // - Fields
        // - With no initializer
        // - With null initializer
        // - With lambda expressions
        // - With array initializers without new
    }

}
