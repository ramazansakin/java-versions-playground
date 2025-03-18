package org.example.java9;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import java.net.URI;
import java.util.concurrent.CompletableFuture;


// 6. New HTTP Client API (incubator in Java 9, standardized in Java 11)
public class HttpClientExample {

    public static void main(String[] args) throws Exception {
        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.example.org/data"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Synchronous send
        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Body: " + response.body());

        // Asynchronous send
        CompletableFuture<HttpResponse<String>> futureResponse =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        futureResponse.thenAccept(resp -> {
            System.out.println("Async status code: " + resp.statusCode());
            System.out.println("Async body: " + resp.body());
        });
    }

}
