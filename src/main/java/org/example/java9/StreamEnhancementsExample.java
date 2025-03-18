package org.example.java9;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 3. Stream API Enhancements
public class StreamEnhancementsExample {

    public static void main(String[] args) {
        // takeWhile() - takes elements while predicate is true
        List<Integer> numbers = List.of(2, 4, 6, 8, 9, 10, 12);
        List<Integer> taken = numbers.stream()
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList()); // [2, 4, 6, 8]
        System.out.println("takeWhile: " + taken);

        // dropWhile() - drops elements while predicate is true
        List<Integer> dropped = numbers.stream()
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList()); // [9, 10, 12]
        System.out.println("dropWhile: " + dropped);

        // iterate() with predicate
        List<Integer> iterateWithPredicate = Stream.iterate(1, n -> n <= 10, n -> n + 1)
                .collect(Collectors.toList()); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println("iterate with predicate: " + iterateWithPredicate);

        // Stream.ofNullable
        Stream<String> streamOfNullable = Stream.ofNullable("Java 9");
        Stream<String> streamOfNull = Stream.ofNullable(null); // empty stream

        // Optional enhancements
        Optional<String> optional = Optional.of("value");
        optional.ifPresentOrElse(
                v -> System.out.println("Value: " + v),
                () -> System.out.println("No value")
        );

        // Optional.stream() - convert Optional to Stream
        List<String> optionalToStream = optional.stream().collect(Collectors.toList()); // [value]

    }

}