package org.example.java8.streams;


import java.util.StringJoiner;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*

1- Basic Stream Creation: Create a stream of integers from 1 to 10 and print each element.
2- Filtering with Stream: Create a stream of strings and filter out the strings that have length less than 5.
3- Mapping with Stream: Create a stream of integers, map each integer to its square, and print the resulting stream.
4- Reduce Operation: Create a stream of integers and use the reduce operation to calculate the sum of all elements.
5- Combining Streams: Create two streams of integers, combine them into a single stream, and print the elements.

*/
public class StreamAPIBasics {

    public static void main(String[] args) {
        // Basic Stream Creation
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // Filtering with Stream
        Stream<String> stringStream = Stream.of("apple", "banana", "grape", "kiwi", "orange");
        stringStream.filter(s -> s.length() >= 5)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // Mapping with Stream
        IntStream.rangeClosed(1, 5)
                .map(i -> i * i)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // Reduce Operation
        IntBinaryOperator intAdditionOp = (left, right) -> {
            return left + right;
        };

        int sum = IntStream.rangeClosed(1, 10)
                .reduce(0, intAdditionOp);

        System.out.println("Sum of integers from 1 to 10: " + sum);

        System.out.println("-------------------------------------------------------------------");

        // Combining Streams
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> combinedStream = Stream.concat(stream1, stream2);
        System.out.println("Stream Combination : ");
        combinedStream.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // Recreate the streams
        stream1 = Stream.of(1, 2, 3);
        stream2 = Stream.of(4, 5, 6);
        Stream<Integer> combinedStream2 = Stream.concat(stream1, stream2);

        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // Create new one like above combinedStream2
        combinedStream2.map(Object::toString)
                .forEach(joiner::add);

        System.out.println("Combined elements: " + joiner.toString());

    }

}
