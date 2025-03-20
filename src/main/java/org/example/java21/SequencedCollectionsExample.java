package org.example.java21;

import java.util.*;

public class SequencedCollectionsExample {

    public static void main(String[] args) {
        SequencedSet<String> names = new LinkedHashSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("First: " + names.getFirst()); // Alice
        System.out.println("Last: " + names.getLast());   // Charlie
    }

}

