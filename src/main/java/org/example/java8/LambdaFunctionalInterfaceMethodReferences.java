package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctionalInterfaceMethodReferences {

    public static void main(String[] args) {

        // Old way - NOT Lambda
        Calculator adder = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        // Impl by Lambda
        Calculator adder2 = (a, b) -> a + b;

        // Impl by Method Reference
        Calculator adder3 = Integer::sum;

        int adderResult = adder.calculate(10, 4);

        int adder3Result = adder.calculate(10, 4);

        // String Interpolation
        System.out.printf("adder result : %s | adder3 result : %s", adderResult, adder3Result);
        System.out.println();

        if (adderResult == adder3Result)
            System.out.println("Adders are same!");
        else
            System.out.println("Adders are NOT same!");

        System.out.println("-------------------------------------------------------------------");

        // Subs by Lambda
        Calculator substructor1 = (a, b) -> a - b;

        // Subs by custom method reference
        Calculator substructor2 = LambdaFunctionalInterfaceMethodReferences::substruct;


        // Predicate Usage
        // Use Built-in Functional Interfaces: Use the Predicate functional interface to create a method
        // that takes a list of integers and returns a new list containing only the even numbers.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("Even numbers: " + evenNumbers);

        System.out.println("-------------------------------------------------------------------");

        Function<Integer, Integer> foo1 = (Integer a) -> {
            return a + 10;
        };

        Function<Integer, Integer> foo2 = x -> 2 * x + 1;

        int result = doubleFunction(foo2, 10);
        System.out.println("doubleFunction with foo result : " + result);

        // type casting
        Function<Integer, Integer> bar = x -> (int) Math.pow(x, 2) + 1;

        result = doubleFunction(bar, 2);
        System.out.println("doubleFunction with bar result : " + result);

        System.out.println("-------------------------------------------------------------------");

        Function<Integer, Integer> f1 = x -> x + 3;
        Function<Integer, Integer> f2 = x -> 2 * x + 1;

        result = doubleFunction(f1, f2, 5);
        System.out.println("doubleFunction with 2 Functions f1, f2 result : " + result);

        result = doubleFunctionCompose(f1, f2, 5);
        System.out.println("doubleFunctionCompose with 2 Functions f1, f2 result : " + result);

        System.out.println("-------------------------------------------------------------------");

        BinaryOperation divideOperation = (a, b) -> {
            // Check if b is not zero to avoid division by zero
            if (b != 0) {
                // Perform the division
                return a % b == 0; // Change this condition as per your operation
            } else {
                // Division by zero, operation failed
                return false;
            }
        };

        // Test the divide operation
        int dividend = 10;
        int divisor = 2;
        boolean res = divideOperation.operate(dividend, divisor);
        System.out.println("Division succeeded: " + res);

        // Test with divisor as zero
        divisor = 0;
        res = divideOperation.operate(dividend, divisor);
        System.out.println("Division succeeded: " + res);

        System.out.println("-------------------------------------------------------------------");

        // Define a lambda expression and pass it to executeAction method
        executeAction(() -> System.out.println("Executing action 1"));

        // Define a method reference and pass it to executeAction method

        // If the method is not STATIC, need to instantiate an object and use it
        // LambdaFunctionalInterfaceMethodReferences mainInstance = new LambdaFunctionalInterfaceMethodReferences();

        executeAction(LambdaFunctionalInterfaceMethodReferences::performCustomAction);

        System.out.println("-------------------------------------------------------------------");

        Supplier<String> supplier = () -> {
            if (Math.random() < 0.5) {
                throw new RuntimeException("Random failure!");
            }
            return "Success!";
        };

        String resultSupplier = executeSupplier(supplier, "Default Value");
        System.out.println("Result: " + resultSupplier);

        System.out.println("-------------------------------------------------------------------");

        // Q - Compose Predicates: Write a method that takes two Predicate instances and returns a new predicate that represents their logical AND.

        // A
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isPositive = num -> num > 0;

        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);

        System.out.println("Is 6 even and positive? " + isEvenAndPositive.test(6)); // Output: true
        System.out.println("Is -3 even and positive? " + isEvenAndPositive.test(-3)); // Output: false
        System.out.println("Is 5 even and positive? " + isEvenAndPositive.test(5)); // Output: false


        System.out.println("-------------------------------------------------------------------");

        // Suppose you have a functional interface MathOperation with a single abstract method int calculate(int a, int b)
        // which performs a mathematical operation on two integers and returns the result. However, some operations may result in exceptions, such as division by zero.
        // Test addition
        testMathOperation((a, b) -> a + b, 10, 20);

        // Test subtraction
        testMathOperation((a, b) -> a - b, 20, 10);

        // Test multiplication
        testMathOperation((a, b) -> a * b, 5, 6);

        // Test division
        testMathOperation((a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }, 20, 0);

        System.out.println("-------------------------------------------------------------------");


    }


    // **
    // Custom Functional Interface
    // Create a simple functional interface called Calculator with a single abstract method int calculate(int a, int b);
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    public static int substruct(int a, int b) {
        return a - b;
    }


    // **
    // Built-in Predicate Functional Interface
    // Use the Predicate functional interface to create a method that takes a list of integers and returns a new list containing only the even numbers.
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        // stream way
        List<Integer> evenNumbers = numbers.stream().filter(isEven).toList();

        // Old way
//        for (Integer num : numbers) {
//            if (isEven.test(num)) {
//                evenNumbers.add(num);
//            }
//        }
        return evenNumbers;
    }

    public static int doubleFunction(Function<Integer, Integer> foo, Integer value) {
//        return foo.apply(foo.apply(value));
        Function<Integer, Integer> thenFunction = foo.andThen(foo);
        return thenFunction.apply(value);
    }

    // Method Overloading
    public static int doubleFunction(Function<Integer, Integer> f1, Function<Integer, Integer> f2, Integer value) {
//        return f1.apply(f2.apply(value));

        Function<Integer, Integer> thenFunc = f1.andThen(f2);
        return thenFunc.apply(value);
    }


    public static int doubleFunctionCompose(Function<Integer, Integer> f1, Function<Integer, Integer> f2, Integer value) {
//        return f1.apply(f2.apply(value));

        Function<Integer, Integer> composedFunc = f1.compose(f2);
        return composedFunc.apply(value);
    }


    // **
    // Custom Functional Interfaces: Create a custom functional interface for a binary operation
    // that takes two integers and returns a boolean result indicating whether the operation succeeded.
    @FunctionalInterface
    interface BinaryOperation {
        boolean operate(int a, int b);
    }


    // **
    // Functional Interface as Method Parameter: Write a method that takes a functional interface as a parameter and executes it.
    @FunctionalInterface
    interface MyFunctionalInterface {
        void performAction();
    }

    // **
    // Optional to use @FunctionalInterface, its a "Marker annotation"
//    @FunctionalInterface
    public static void executeAction(MyFunctionalInterface action) {
        action.performAction();
    }

    private static void performCustomAction() {
        System.out.println("Executing custom action");
    }


    // **
    // Exception Handling with Functional Interfaces: Write a method that takes a Supplier<T> and returns a T,
    // handling any exceptions that might be thrown by the supplier.
    // It needs to be used for default value provides in any exceptional-case
    public static <T> T executeSupplier(Supplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            return defaultValue;
        }
    }


    // **
    // Functional Interface with Exception Handling
    @FunctionalInterface
    interface MathOperation {
        int calculate(int a, int b);
    }

    // Method to test MathOperation with exception handling
    private static void testMathOperation(MathOperation operation, int a, int b) {

        try {
            int result = operation.calculate(a, b);
            System.out.println("Result: " + result);
        } catch (Throwable e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}