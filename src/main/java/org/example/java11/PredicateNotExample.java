package org.example.java11;

// 9. Predicate.not Method
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNotExample {

    public static void main(String[] args) {
        List<String> languages = List.of("Java", "", "Kotlin", "", "Scala");

        // Before Java 11
        List<String> nonEmptyBefore = languages.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        // With Java 11 - using Predicate.not
        List<String> nonEmpty = languages.stream()
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toList());

        System.out.println("Non-empty languages: " + nonEmpty);

        // Another example with custom predicate
        Predicate<String> containsA = s -> s.contains("a");
        List<String> withoutA = languages.stream()
                .filter(Predicate.not(containsA))
                .collect(Collectors.toList());

        System.out.println("Languages without 'a': " + withoutA);
    }

}
