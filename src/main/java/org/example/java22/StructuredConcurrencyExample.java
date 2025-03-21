package org.example.java22;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class StructuredConcurrencyExample {

    public static void main(String args) throws InterruptedException {
        try (var scope = new StructuredTaskScope<String>()) {
            Subtask<String> task1 = scope.fork(() -> findUser());
            Subtask<String> task2 = scope.fork(() -> fetchOrder());

            scope.join();

            String user = task1.get();
            String orderId = task2.get();

            System.out.println("User: " + user + ", Order ID: " + orderId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String findUser() throws InterruptedException {
        System.out.println("Finding user...");
        Thread.sleep(100);
        return "John Doe";
    }

    private static String fetchOrder() throws InterruptedException {
        System.out.println("Fetching order...");
        Thread.sleep(150);
        return "12345";
    }
}
