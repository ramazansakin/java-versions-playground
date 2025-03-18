package org.example.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


// 4. APIs for Creating Unmodifiable Collections
public class UnmodifiableCollectionsAPIExample {

    public static void main(String[] args) {
        // Create a modifiable list
        var mutableList = new ArrayList<String>();
        mutableList.add("Java");
        mutableList.add("Kotlin");

        // Create unmodifiable copy using copyOf
        var immutableList = List.copyOf(mutableList);

        // Create unmodifiable set and map
        var immutableSet = Set.copyOf(mutableList);

        // Demonstrating Map.copyOf
        var mutableMap = new HashMap<String, Integer>();
        mutableMap.put("Java", 10);
        mutableMap.put("Kotlin", 1);

        var immutableMap = Map.copyOf(mutableMap);

        // Verify immutability
        try {
            immutableList.add("C#"); // Will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable list");
        }
    }

}
