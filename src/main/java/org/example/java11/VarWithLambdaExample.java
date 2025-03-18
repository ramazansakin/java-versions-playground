package org.example.java11;

import java.util.function.Consumer;
import java.util.stream.Stream;


// 5. Local-Variable Syntax for Lambda Parameters
public class VarWithLambdaExample {

    public static void main(String[] args) {
        // Before Java 11
        Consumer<String> printerOld = (String s) -> System.out.println(s);

        // With Java 11 - can use 'var' in lambda parameters
        Consumer<String> printer = (var s) -> System.out.println(s);
        printer.accept("Hello from var in lambda!");

        // Useful with annotations
        Stream.of("Java", "Kotlin", "Scala")
                .map((@NonNull var s) -> s.toUpperCase())
                .forEach(System.out::println);
    }

    // For demonstration only - this mimics the @NonNull annotation
    @interface NonNull {
    }

}
