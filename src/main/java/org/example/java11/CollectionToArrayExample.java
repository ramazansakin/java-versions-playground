package org.example.java11;

import java.util.Arrays;
import java.util.List;


// 7. Collection.toArray(IntFunction) Method
public class CollectionToArrayExample {

    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Kotlin", "Scala", "Groovy");

        // Before Java 11
        String[] arrayOld = languages.toArray(new String[0]);

        // With Java 11
        String[] array = languages.toArray(String[]::new);

        System.out.println("Languages array: " + Arrays.toString(array));

        // Works with any collection
        var numbers = List.of(1, 2, 3, 4, 5);
        Integer[] numArray = numbers.toArray(Integer[]::new);
        System.out.println("Numbers array: " + Arrays.toString(numArray));
    }

}
