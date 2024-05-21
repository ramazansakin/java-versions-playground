package org.example.java8;

import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {

    public static void main(String[] args) {

        Function<Integer, Integer> testFunction =
                x -> (int) ((5 * Math.tan(x) / Math.cos(30 * x) + 5) * Math.getExponent(x / 10));

        Function<Integer, Integer> testF = x -> 2 * x + 1;
        int n = 5;
        Optional<Integer> result = applyFunction(testF, n);
        System.out.println("Result with non-null parameter = " + result); // Output: Optional[11]


        // Test with null value
        Integer nullValue = null;
        Optional<Integer> resultWithNull = applyFunction(testF, nullValue);
        System.out.println("Result with null parameter = " + resultWithNull); // Output: Optional.empty


        System.out.println("-------------------------------------------------------------------");
        // if not null
        Optional temp = result;
        if (temp.isPresent()) {
            System.out.println("Result is not null - " + temp.get());
        } else {
            System.out.println("Result is not null - " + temp.get());
        }


        System.out.println("-------------------------------------------------------------------");

        Optional<String> optionalString1 = Optional.of("Java");
        Optional<String> optionalString2 = Optional.of("Hello World");
        Optional<String> optionalString3 = Optional.empty();

        System.out.println(isValidString(optionalString1)); // Output: true
        System.out.println(isValidString(optionalString2)); // Output: false
        System.out.println(isValidString(optionalString3)); // Output: true

    }


    // Optional with Functional Interfaces: Write a method that takes a Function<Integer, Integer> and an integer n,
    // and returns the result of applying the function to n if n is not
    public static Optional<Integer> applyFunction(Function<Integer, Integer> function, Integer n) {
        if (n != null) {
            return Optional.ofNullable(function.apply(n));
        } else {
            return Optional.empty();
        }
    }


    // Q - Filtering with Optional: Write a method that takes an Optional<String> and returns true
    // if the string is not blank and has more than 5 characters, otherwise returns false.
    public static boolean isValidString(Optional<String> optional) {
        return optional.filter(s -> !s.isBlank() && s.length() > 5).isPresent();
    }


}
