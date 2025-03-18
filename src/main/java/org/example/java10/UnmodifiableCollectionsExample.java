package org.example.java10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// 2. Unmodifiable Collections Enhancements
public class UnmodifiableCollectionsExample {

    public static void main(String[] args) {
        // Create a modifiable list
        var mutableList = new ArrayList<String>();
        mutableList.add("Java");
        mutableList.add("Kotlin");

        // Before Java 10 - create unmodifiable copy
        List<String> unmodifiableBefore = Collections.unmodifiableList(new ArrayList<>(mutableList));

        // In Java 10 - copyOf method creates unmodifiable copy
        var unmodifiableCopy = List.copyOf(mutableList);

        // Works for Set and Map too
        var set = Set.copyOf(Set.of("Java", "Kotlin", "Scala"));
        var map = Map.copyOf(Map.of("one", 1, "two", 2));

        // Stream collectors have new toUnmodifiableList/Set/Map methods
        var unmodifiableList = Stream.of("Java", "Kotlin", "Scala")
                .collect(Collectors.toUnmodifiableList());

        var unmodifiableSet = Stream.of("Java", "Kotlin", "Scala")
                .collect(Collectors.toUnmodifiableSet());

        var unmodifiableMap = Stream.of("Java", "Kotlin", "Scala")
                .collect(Collectors.toUnmodifiableMap(
                        s -> s,
                        String::length
                ));

        // Verify the collections are unmodifiable
        try {
            unmodifiableList.add("C#"); // Will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify unmodifiable collections");
        }
    }

}
