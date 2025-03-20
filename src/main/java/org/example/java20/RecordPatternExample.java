package org.example.java20;

record Point(int x, int y) {}

public class RecordPatternExample {

    static void printCoordinates(Point p) {
        switch (p) {
            case Point(int x, int y) -> System.out.println("Coordinates: " + x + ", " + y);
            default -> System.out.println("Unknown object");
        }
    }

    public static void main(String[] args) {
        printCoordinates(new Point(10, 20));
    }

}
