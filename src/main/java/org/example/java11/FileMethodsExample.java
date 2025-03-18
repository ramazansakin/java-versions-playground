package org.example.java11;

// 6. New File Methods (writeString, readString)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileMethodsExample {

    public static void main(String[] args) throws IOException {
        // Create a temporary file
        Path filePath = Files.createTempFile("java11demo", ".txt");

        // Write string to file (new in Java 11)
        Files.writeString(filePath, "Hello Java 11!\nThis is a test file.");
        System.out.println("File written to: " + filePath);

        // Append to file
        Files.writeString(filePath,
                "\nAppending more text.",
                StandardOpenOption.APPEND);

        // Read string from file (new in Java 11)
        String content = Files.readString(filePath);
        System.out.println("File content:\n" + content);

        // Clean up
        Files.deleteIfExists(filePath);
    }

}
