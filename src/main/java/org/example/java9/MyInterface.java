package org.example.java9;

// 4. Private Methods in Interfaces
interface MyInterface {

    // Constants
    static final String PREFIX = "prefix_";

    // Private static method
    private static void staticCommonLogic() {
        System.out.println("Common static logic");
    }

    // Static method that can use private static methods
    static void staticMethod() {
        staticCommonLogic();
        System.out.println("Static method");
    }

    // Abstract method
    void abstractMethod();

    // Default method
    default void defaultMethod() {
        commonLogic();
        System.out.println("Default method implementation");
    }

    // Another default method
    default void anotherDefaultMethod() {
        commonLogic();
        System.out.println("Another default method");
    }

    // Private method - can be called from default methods
    private void commonLogic() {
        System.out.println("Common logic used by multiple default methods");
    }

}
