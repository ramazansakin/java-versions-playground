package org.example.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientAPI {

    // Normally, with Java8 we could use CompletableFuture to run thread inside our class scope to asynchronously do something
    // and handle it, but if we want to call external api as async, we can use HttpClient now, JDK11

    public static void main(String[] args) {
        // Create an HttpClient instance
        HttpClient httpClient = HttpClient.newHttpClient();

        // Define the URL for the GET request
        String url = "https://jsonplaceholder.typicode.com/posts/5";

        // Create a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send the GET request asynchronously
        CompletableFuture<Void> responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(HttpClientAPI::handleResponse)
                .exceptionally(HttpClientAPI::handleError);

        // Wait for the response to complete
        responseFuture.join();
    }

    // Handle the successful response
    private static void handleResponse(String responseBody) {
        System.out.println("Response received:");
        System.out.println(responseBody);
    }

    // Handle errors
    private static Void handleError(Throwable throwable) {
        System.err.println("Error occurred:");
        throwable.printStackTrace();
        return null;
    }

}
