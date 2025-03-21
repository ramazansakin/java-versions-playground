package org.example.java22;

record Customer(String name, String email, int age) {}

public class UnnamedPatternExample {

    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "alice@example.com", 30);

        if (customer instanceof Customer(String name, _, int age) && age > 25) {
            System.out.println("Customer Name: " + name);
        }
    }

}
