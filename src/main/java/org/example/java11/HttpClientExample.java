package org.example.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


// 2. HTTP Client API (Standardized)

public class HttpClientExample {

    public static void main(String[] args) throws Exception {
        // Create an HTTP client
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        // Build a request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .timeout(Duration.ofSeconds(30))
                .header("User-Agent", "Java 11 HttpClient")
                .GET()
                .build();

        // Synchronous send
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        // Asynchronous send
        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(
                request, HttpResponse.BodyHandlers.ofString());

        futureResponse.thenAccept(resp -> {
            System.out.println("Async Status code: " + resp.statusCode());
        });

        // Wait for the async request to complete
        futureResponse.get();

        // POST request example
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\"Java\",\"version\":11}"))
                .build();

        HttpResponse<String> postResponse = client.send(postRequest,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("POST Status: " + postResponse.statusCode());
    }

}