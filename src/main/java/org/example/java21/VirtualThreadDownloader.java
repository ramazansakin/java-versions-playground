package org.example.java21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadDownloader {

    public static void main(String[] args) throws InterruptedException {
        int numFiles = 5; // Number of files to download
        String[] urls = { // Sample file URLs
                "https://example.com/file1.zip",
                "https://example.com/file2.pdf",
                "https://example.com/file3.txt",
                "https://example.com/file4.jpg",
                "https://example.com/file5.mp3"
        };

        // Create an ExecutorService with virtual threads
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // Download each file asynchronously using a virtual thread
        for (String url : urls) {
            executor.submit(() -> downloadFile(url));
        }

        // Wait for all downloads to finish (simulated)
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS); // Wait for max 10 seconds

        System.out.println("All downloads completed (simulated)");
    }

    private static void downloadFile(String url) {
        // Simulate downloading a file
        try {
            Thread.sleep(1000); // Simulate download time
            System.out.println("Downloaded file: " + url + " (on virtual thread: " + Thread.currentThread().getName() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

