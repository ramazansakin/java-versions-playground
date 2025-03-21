package org.example.java22;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;


// Scoped Values provide a safer alternative to ThreadLocal for storing per-request user data.
public class ScopedValueExample {

    // Define a ScopedValue
    private static final ScopedValue<String> USER_CONTEXT = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException {
        // Bind the ScopedValue to a specific value for the scope of the run method
        ScopedValue.where(USER_CONTEXT, "Alice");
    }

    private void run() throws InterruptedException {
        // The ScopedValue is accessible within this scope
        System.out.println("User in main thread: " + USER_CONTEXT.get());

        // Use Structured Concurrency to create a new scope
        try (var scope = new StructuredTaskScope<>()) {
            Subtask<String> task = scope.fork(() -> {
                // The ScopedValue is also accessible within the child thread
                return "User in child thread: " + USER_CONTEXT.get();
            });

            scope.join(); // Wait for the task to complete
            System.out.println(task.get());
        }
    }
}
