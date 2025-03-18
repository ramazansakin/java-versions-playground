package org.example.java11;

public class Others {

    // 10. Epsilon: A No-Op Garbage Collector
    // (Not directly demonstrable in code - it's a JVM feature)
    public static class EpsilonGCExample {
        public static void main(String[] args) {
            System.out.println("Java 11 introduces Epsilon: A No-Op Garbage Collector");
            System.out.println("Useful for:");
            System.out.println("1. Performance testing");
            System.out.println("2. Memory pressure testing");
            System.out.println("3. Short-lived jobs");
            System.out.println("4. Last-drop latency improvements");
            System.out.println("5. VM interface testing");

            // To use Epsilon GC:
            // java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC EpsilonGCExample

            System.out.println("Note: With Epsilon GC, the application will run until it exhausts memory!");
        }
    }

    // 12. ZGC: A Scalable Low-Latency Garbage Collector (Experimental)
    // (Not directly demonstrable in code - it's a JVM feature)
    public static class ZGCExample {
        public static void main(String[] args) {
            System.out.println("Java 11 introduces ZGC: A Scalable Low-Latency Garbage Collector");
            System.out.println("Benefits:");
            System.out.println("1. Low latency (< 10ms pause times)");
            System.out.println("2. Scales well from small to huge heaps (8MB - 16TB)");
            System.out.println("3. Works well with high object allocation rates");

            // To use ZGC:
            // java -XX:+UnlockExperimentalVMOptions -XX:+UseZGC ZGCExample
        }
    }

}
