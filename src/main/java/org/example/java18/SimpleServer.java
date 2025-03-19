package org.example.java18;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Serve static files from "public" directory
        server.createContext("/", exchange -> {
            Path filePath = Path.of("public", exchange.getRequestURI().getPath());
            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                exchange.sendResponseHeaders(200, Files.size(filePath));
                Files.copy(filePath, exchange.getResponseBody());
            } else {
                String response = "404 - File Not Found";
                exchange.sendResponseHeaders(404, response.length());
                exchange.getResponseBody().write(response.getBytes());
            }
            exchange.close();
        });

        // Custom API endpoint returning JSON
        server.createContext("/api/hello", new HelloHandler());

        server.start();
        System.out.println("Server started at http://localhost:" + port);
    }

    // JSON API handler
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String jsonResponse = "{\"message\": \"Hello, Java 18 Web Server!\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, jsonResponse.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(jsonResponse.getBytes());
                }
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                exchange.close();
            }
        }
    }

}

