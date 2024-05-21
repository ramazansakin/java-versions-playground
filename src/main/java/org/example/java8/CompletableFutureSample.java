package org.example.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;

public class CompletableFutureSample {


//    CompletableFuture is a class introduced in Java 8 that represents the asynchronous execution of a task.
//    It provides a mechanism to handle the result of the task when it completes, either successfully or with an exception.
//    Asynchronous Operations:
//          CompletableFuture enables defining and executing tasks asynchronously. This means the task runs in a separate thread without blocking the main thread.
//    Promise-based Model:
//          It functions similarly to promises in other languages. You don't directly wait for the task to finish; instead, you specify what actions to take when the result is available (success or failure).

//    Runnable vs Callable

//    1- Create a CompletableFuture: Create a CompletableFuture that completes with a result of "Hello, world!" after a short delay.
//    2- Handle Exception: Create a CompletableFuture that completes exceptionally with a RuntimeException.
//    3- Combine CompletableFutures: Create two CompletableFutures, one that completes with a result of "Hello" and another
//    that completes with a result of "World", and then combine them to create a new CompletableFuture that completes with the concatenated string "Hello, World".
//    4- Chain CompletableFutures: Create a chain of CompletableFutures where each stage processes the result of the previous stage.
//    For example, one stage could convert a string to uppercase, and another stage could append a suffix.
//    5- Handle Timeout: Create a CompletableFuture that completes exceptionally with a TimeoutException if it takes longer than a specified duration to complete.

    public static void main(String[] args) {

        // 1- Create a CompletableFuture: Create a CompletableFuture that completes with a result of "Hello, world!" after a short delay.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate some processing time
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, world!";
        });

        // Wait for the CompletableFuture to complete and print the result
        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------------------");

        // 2- Handle Exception: Create a CompletableFuture that completes exceptionally with a RuntimeException.
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            throw new RuntimeException("Something went wrong!");
        });

        // Handle the exception and print the error message
        future2.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null;    // Return null to suppress the exception
        }).join();          // Wait for the CompletableFuture to complete

        System.out.println("-------------------------------------------------------------------");


        // 3- Combine CompletableFutures: Create two CompletableFutures, one that completes with a result of "Hello" and another
        // that completes with a result of "World", and then combine them to create a new CompletableFuture that completes with the concatenated string "Hello, World".
        // Create two CompletableFutures that complete with "Hello" and "World" respectively
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "World");

        // Combine the CompletableFutures to create a new CompletableFuture that completes with "Hello, World"
        BiFunction<String, String, String> nameCombinator = (name1, name2) -> name1 + ", " + name2;
        CompletableFuture<String> combinedFuture = futureA.thenCombine(futureB, nameCombinator);

        // CompletableFuture<String> combinedFuture = futureA.thenCombine(futureB, (name1, name2) -> name1 + ", " + name2);

        // Wait for the combined CompletableFuture to complete and print the result
        // String result = combinedFuture.join();
        System.out.println("Combined Result: " + combinedFuture.toString());

        System.out.println("-------------------------------------------------------------------");

        // 4- Chain CompletableFutures: Create a chain of CompletableFutures where each stage processes the result of the previous stage.
        // For example, one stage could convert a string to uppercase, and another stage could append a suffix.
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(String::toUpperCase)
                .thenApply(s -> s + ", world");

        future3.thenAccept(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // 5- Handle Timeout: Create a CompletableFuture that completes exceptionally with a TimeoutException if it takes longer than a specified duration to complete.
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate a long-running task
                Thread.sleep(3100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "12345";
        });

        CompletableFuture<String> timeoutFuture = future5.orTimeout(3, TimeUnit.SECONDS);

        timeoutFuture.whenComplete((result, exception) -> {
            if (exception instanceof TimeoutException) {
                System.out.println("Task timed out");
            } else {
                System.out.println("Result: " + result);
            }
        }).join();

        System.out.println("-------------------------------------------------------------------");

    }

}