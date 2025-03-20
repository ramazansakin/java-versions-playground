//package org.example.java21;
//
//import java.lang.ScopedValue;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class ScopedValueExample {
//
//    // Define a ScopedValue
//    static final ScopedValue<String> USER_ID = ScopedValue.newInstance();
//
//    public static void main(String[] args) {
//        // Simulate a request with a user ID
//        String userId = generateUserId();
//
//        // Bind the ScopedValue for the duration of the execution
//        ScopedValue.runWhere(USER_ID, userId, () -> {
//            // Access the ScopedValue within the scope
//            System.out.println("Processing request for user: " + USER_ID.get());
//
//            // Simulate some nested operations
//            performDatabaseOperation();
//            performLogging();
//
//            // Example of a nested scope, that doesn't change the value.
//            ScopedValue.runWhere(USER_ID, USER_ID.get(), () -> {
//                System.out.println("Nested operation for user: " + USER_ID.get());
//            });
//
//            // Example of a nested scope, that shadows the value.
//            ScopedValue.runWhere(USER_ID, "ANONYMOUS", () -> {
//                System.out.println("Anonymous operation for user: " + USER_ID.get());
//            });
//
//            System.out.println("Back to original user: " + USER_ID.get());
//
//        });
//
//        // Outside the scope, the ScopedValue is unbound
//        try {
//            System.out.println("Outside scope: " + USER_ID.get());
//        } catch (IllegalStateException e) {
//            System.out.println("Outside scope: ScopedValue is unbound.");
//        }
//    }
//
//    static void performDatabaseOperation() {
//        System.out.println("Database operation for user: " + USER_ID.get());
//    }
//
//    static void performLogging() {
//        System.out.println("Logging operation for user: " + USER_ID.get());
//    }
//
//    static String generateUserId() {
//        return "user-" + ThreadLocalRandom.current().nextInt(1000);
//    }
//}
//
