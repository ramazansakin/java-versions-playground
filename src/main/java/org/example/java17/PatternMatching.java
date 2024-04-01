package org.example.java17;

enum PaymentStatus {PENDING, COMPLETED, FAILED}

class Order {
    private final String item;
    private final PaymentStatus status;

    public Order(String item, PaymentStatus status) {
        this.item = item;
        this.status = status;
    }

    public void processOrder() {
        switch (status) {
            case PENDING -> System.out.println("Order is pending, awaiting payment.");
            case COMPLETED -> System.out.println("Order completed successfully!");
            case FAILED -> {
                if (status instanceof PaymentStatus reason && reason == PaymentStatus.FAILED) {
                    System.out.println("Order failed due to: " + reason);
                } else {
                    System.out.println("Order failed for unknown reason.");
                }
            }
        }
    }
}

public class PatternMatching {
    public static void main(String[] args) {
        Order order1 = new Order("Book", PaymentStatus.PENDING);
        order1.processOrder(); // Output: Order is pending, awaiting payment.

        Order order2 = new Order("Laptop", PaymentStatus.COMPLETED);
        order2.processOrder(); // Output: Order completed successfully!

        Order order3 = new Order("Headphones", PaymentStatus.FAILED);
        order3.processOrder(); // Output: Order failed for unknown reason.
    }
}

