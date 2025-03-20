package org.example.java21;

import java.util.concurrent.*;

// Run thousands of lightweight threads without worrying about system resources.
// Makes concurrency simpler, cheaper, and faster!
public class VirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                executor.submit(() -> System.out.println(Thread.currentThread()));
            }
        }
    }

}

