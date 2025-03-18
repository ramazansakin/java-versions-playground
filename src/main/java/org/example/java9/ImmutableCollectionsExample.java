package org.example.java9;

import java.util.*;


// 2. Factory Methods for Immutable Collections
public class ImmutableCollectionsExample {

    public static void main(String[] args) {
        // Before Java 9
        List<String> oldList = Collections.unmodifiableList(Arrays.asList("one", "two", "three"));

        // Java 9 way
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, Integer> map = Map.of(
                "one", 1,
                "two", 2,
                "three", 3
        );

        // For larger maps
        Map<String, Integer> largeMap = Map.ofEntries(
                Map.entry("one", 1),
                Map.entry("two", 2),
                Map.entry("three", 3),
                Map.entry("four", 4)
        );

        // Try to modify (will throw UnsupportedOperationException)
        try {
            list.add("four"); // This will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable collections");
        }

        list.set(1, "New Value");

    }

}
