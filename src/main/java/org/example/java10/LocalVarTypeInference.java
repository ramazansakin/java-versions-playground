package org.example.java10;

import java.util.ArrayList;
import java.util.Arrays;

public class LocalVarTypeInference {

    public static void main(String[] args) {
        // Explicit type declaration
        String messageExplicit = "Hello, Java 10!";
        System.out.println(messageExplicit);

        // Inferred type using var
        var messageInferred = "Hello, Java 10 with var!";
        System.out.println(messageInferred);

        // Inferred type with arrays
        var numbers = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        // Inferred type with generic types
        var list = new ArrayList<String>();
        list.add("Java");
        list.add("is");
        list.add("awesome");
        System.out.println(list);

        // Inferred type with custom class
        var person = new Person();

    }

    static class Person {
        private String name;
    }

}
