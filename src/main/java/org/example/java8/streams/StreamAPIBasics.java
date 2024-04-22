package org.example.java8.streams;


import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
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
                .forEach((number) -> System.out.println(number));

        System.out.println("-------------------------------------------------------------------");

        // Filtering with Stream
        Stream<String> stringStream = Stream.of("apple", "banana", "grape", "kiwi", "orange");
        stringStream.filter(s -> s.length() >= 5)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // Mapping with Stream
        IntStream.rangeClosed(1, 5)
                .map(i -> i * i)    // transformation
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
        System.out.println("-------------------------------------------------------------------");

        // Streaming int array and mapping, filtering, collecting in anyway you want
        // Sum of Even Numbers

        int[] arr = {1, 2, 3, 4, 5, 6};
        int sum2 = Arrays.stream(arr)
                .filter(num -> num % 2 == 0)
                .sum();

        System.out.println("Sum -> " + sum2);
        System.out.println("-------------------------------------------------------------------");

        // Count Positive Numbers
        int[] arr2 = {-2, 3, 0, 5, -1, 8};
        long count = Arrays.stream(arr2)
                .filter(num -> num > 0)
                .count();

        System.out.println("Count of positive numbers -> " + count);
        System.out.println("-------------------------------------------------------------------");

        // Concatenate Strings
        String[] arr3 = {"Hello", " ", "World", "!"};
        String concated = Arrays.stream(arr3)
                .collect(Collectors.joining());

        System.out.println("Concatenated Strings from " + Arrays.toString(arr3) + " -> " + concated);
        System.out.println("-------------------------------------------------------------------");

        // Concatenate numbers as one String
        String concatedNumbers = Arrays.stream(arr2).mapToObj(String::valueOf).collect(Collectors.joining());

        System.out.println("Concatenated Numbers from " + Arrays.toString(arr2) + " -> " + concatedNumbers);
        System.out.println("-------------------------------------------------------------------");
    }

}
