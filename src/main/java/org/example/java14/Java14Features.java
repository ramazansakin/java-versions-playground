package org.example.java14;


// 1. Switch Expressions (Standard)
// 2. Records (Preview)
// 3. Pattern Matching for instanceof (Preview)
public class Java14Features {

    public static void main(String[] args) {
        // 1. Switch Expressions (Standardized)
        Day day = Day.WEDNESDAY;

        String result = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> "Start or end of work week";
            case TUESDAY, THURSDAY, SATURDAY -> "Mid or weekend day";
            case WEDNESDAY -> "Midweek";
        };
        System.out.println(result);

        // Switch with yield
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println("Six letter day");
                yield 6;
            }
            case TUESDAY -> {
                System.out.println("Seven letter day");
                yield 7;
            }
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
        System.out.println("Number of letters: " + numLetters);

        // 2. Records (Preview in Java 14)
        // Requires --enable-preview flag in Java 14
        /*
        record Point(int x, int y) {
            // Compact constructor
            public Point {
                if (x < 0 || y < 0) {
                    throw new IllegalArgumentException("Coordinates cannot be negative");
                }
            }

            // Add methods to records
            public double distance() {
                return Math.sqrt(x * x + y * y);
            }
        }

        Point p = new Point(3, 4);
        System.out.println("Point: " + p);
        System.out.println("X coordinate: " + p.x());
        System.out.println("Distance from origin: " + p.distance());
        */

        // 3. Pattern Matching for instanceof (Preview in Java 14)
        // Requires --enable-preview flag in Java 14
        /*
        Object obj = "Hello, Java 14";

        // Old way
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }

        // New way with pattern matching
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }
        */
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

}
