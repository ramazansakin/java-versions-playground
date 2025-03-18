package org.example.java16;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

// 1. Records (Standard)
// 2. Pattern Matching for instanceof (Standard)
// 3. Stream.toList() Method
// 4. Day Period Support
public class Java16Features {
    // 1. Records (Standardized)
    record Customer(String name, String email, int age) {
        // Compact constructor
        public Customer {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }

            // Normalize email
            email = email.toLowerCase().trim();
        }

        // Add methods
        public boolean isAdult() {
            return age >= 18;
        }

        // Static fields and methods are allowed
        public static final int MINIMUM_AGE = 18;
    }

    public static void main(String[] args) {
        // Create and use records
        Customer customer = new Customer("John Doe", "JOHN@example.com", 30);
        System.out.println(customer);
        System.out.println("Name: " + customer.name());
        System.out.println("Email: " + customer.email());
        System.out.println("Is adult: " + customer.isAdult());

        // Records have equals, hashCode, and toString
        Customer c1 = new Customer("John Doe", "john@example.com", 30);
        Customer c2 = new Customer("John Doe", "john@example.com", 30);
        System.out.println("Equal? " + c1.equals(c2));

        // 2. Pattern Matching for instanceof (Standardized)
        Object obj = "Hello, Java 16";

        if (obj instanceof String s) {
            // s is already cast to String
            System.out.println("Length: " + s.length());
            System.out.println("Uppercase: " + s.toUpperCase());
        }

        // 3. Stream.toList() Method
        List<String> names = Stream.of("Alice", "Bob", "Charlie")
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase)
                .toList(); // New in Java 16

        System.out.println(names);

        // 4. Day Period Support
        var now = LocalTime.now();
        var formatter = DateTimeFormatter.ofPattern("B");
        System.out.println("Day period: " + now.format(formatter));

        // Different day periods
        System.out.println("Midnight: " +
                           LocalTime.MIDNIGHT.format(formatter));
        System.out.println("Noon: " +
                           LocalTime.NOON.format(formatter));
        System.out.println("Morning (9 AM): " +
                           LocalTime.of(9, 0).format(formatter));
        System.out.println("Afternoon (3 PM): " +
                           LocalTime.of(15, 0).format(formatter));
        System.out.println("Evening (8 PM): " +
                           LocalTime.of(20, 0).format(formatter));
    }

}
