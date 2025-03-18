package org.example.java10;

import java.util.Optional;
import java.util.NoSuchElementException;


// 3. Optional.orElseThrow() Method
public class OptionalOrElseThrowExample {

    public static void main(String[] args) {
        // Create some optional values
        var emptyOptional = Optional.<String>empty();
        var nonEmptyOptional = Optional.of("Java 10");

        // Before Java 10
        String valueBefore = nonEmptyOptional.get(); // Works but unsafe on empty

        try {
            // Before Java 10 - would throw NoSuchElementException
            String emptyValue = emptyOptional.get();
        } catch (NoSuchElementException e) {
            System.out.println("Empty optional accessed with get()");
        }

        // Java 10 - orElseThrow() method - semantically clearer than get()
        String value = nonEmptyOptional.orElseThrow(); // Same as get() but more explicit

        try {
            String shouldThrow = emptyOptional.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("Empty optional accessed with orElseThrow()");
        }
    }

}
