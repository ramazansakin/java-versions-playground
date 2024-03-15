package org.example.java8;


/*
    # Concurrency
    # Runnable vs Callable
    # Parallel Streams
    # CompletableFuture

    Task:
    Write a program that calculates the sum of squares of numbers from 1 to N concurrently using parallel streams and CompletableFuture.

    Steps:
    1- Create a method called calculateSquare(int number) that takes an integer number and returns its square with "Function" functional interface.
    2- Implement a Supplier<Integer> that generates a stream of numbers from 1 to N.
    3- Use parallel streams to map each number to its square using the calculateSquare method and collect the results into a list of squares.
    4- Write a Consumer<List<Integer>> that calculates the sum of all elements in the list.
    5- Use CompletableFuture to asynchronously execute the consumer to calculate the sum.
    6- Print the final sum.

*/

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrencyWithFunctionalInt {

    public static void main(String[] args) {
        int N = 10; // Define the upper limit of the range

        // Step 1: Create a method to calculate square
        Function<Integer, Integer> calculateSquare = x -> x * x;

        // Step 2: Create a Supplier to generate numbers from 1 to N
        // Auto-boxing & Un-boxing from < primitive <-> reference >
        List<Integer> integerList = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());

        Supplier<List<Integer>> numberSupplier = () ->
                IntStream.rangeClosed(1, N)
                        .boxed()
                        .collect(Collectors.toList());


        // Step 3: Use parallel streams to calculate squares concurrently
        List<Integer> squares = numberSupplier.get()
                .parallelStream()
                .map(calculateSquare)
                .toList();

        // Step 4: Create a Consumer to calculate the sum of squares
        Consumer<List<Integer>> sumCalculator = squareList -> {
            int sum = squareList.stream().reduce(0, Integer::sum);
            System.out.println("--------------------------------");
            System.out.println("Sum of squares: " + sum);
            System.out.println("--------------------------------");
        };

        // Step 5: Use CompletableFuture to execute the consumer asynchronously
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> sumCalculator.accept(squares));

        // Step 6: Join the CompletableFuture to wait for its completion
        future.join();
    }


}
