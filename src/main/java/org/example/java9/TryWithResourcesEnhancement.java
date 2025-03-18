package org.example.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 5. Try-With-Resources Enhancement
public class TryWithResourcesEnhancement {

    public static void main(String[] args) throws IOException {
        // Before Java 9
        BufferedReader oldReader = new BufferedReader(new FileReader("file.txt"));
        try (BufferedReader reader = oldReader) {
            // Use reader
            String line = reader.readLine();
            System.out.println(line);
        }

        // With Java 9 - can use effectively final variables
        BufferedReader newReader = new BufferedReader(new FileReader("file.txt"));
        try (newReader) {
            // Use reader
            String line = newReader.readLine();
            System.out.println(line);
        }
    }

}
