package org.example.java21;

record Point(int x, int y) {}


// Now fully supported for pattern matching inside records!
// Cleaner way to extract values from records.
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

