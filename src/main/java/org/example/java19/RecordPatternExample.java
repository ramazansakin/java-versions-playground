package org.example.java19;

record Point(int x, int y) {}

public class RecordPatternExample {

    static void process(Point p) {
        if (p instanceof Point(int x, int y)) {
            System.out.println("Point coordinates: " + x + ", " + y);
        }
    }

    public static void main(String[] args) {
        process(new Point(10, 20));
    }

}

