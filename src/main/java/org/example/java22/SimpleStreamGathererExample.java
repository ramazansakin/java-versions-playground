package org.example.java22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Gatherer;


public class SimpleStreamGathererExample {

    @SuppressWarnings("preview")
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "cherry", "date", "elderberry");

        // Example: Chunking - group items into pairs with explicit types
        System.out.println("=== Chunking into pairs ===");

        // Define the gatherer with explicit types
        Gatherer<String, List<String>, List<String>> chunkIntoPairs = Gatherer.ofSequential(
                // Initial state supplier with explicit return type
                () -> new ArrayList<>(),

                // Integrator with explicit parameter types
                (List<String> chunk, String element, Gatherer.Downstream<? super List<String>> downstream) -> {
                    chunk.add(element);
                    if (chunk.size() == 2) {
                        downstream.push(new ArrayList<>(chunk));
                        chunk.clear();
                    }
                    return true;
                },

                // Finisher with explicit parameter types
                (List<String> chunk, Gatherer.Downstream<? super List<String>> downstream) -> {
                    if (!chunk.isEmpty()) {
                        downstream.push(new ArrayList<>(chunk));
                    }
                }
        );

        fruits.stream()
                .gather(chunkIntoPairs)
                .forEach(System.out::println);
    }

}