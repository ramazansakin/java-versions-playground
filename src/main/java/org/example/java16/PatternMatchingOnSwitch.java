package org.example.java16;

import java.util.Arrays;
import java.util.List;

interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private final double width;
    private final double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private final double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}


public class PatternMatchingOnSwitch {

    // Old style
    public static double calculateArea(Shape shape) {
        // Traditional approach with instanceof
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else {
            throw new IllegalArgumentException("Unsupported shape type");
        }
    }

    public static double calculateAreaEnhanced(Shape shape) {
        // Using Java 16 pattern matching
        return switch (shape) {
            case Rectangle rectangle -> rectangle.getWidth() * rectangle.getHeight();
            case Circle circle -> Math.PI * circle.getRadius() * circle.getRadius();
            default -> throw new IllegalArgumentException("Unsupported shape type");
        };
    }

    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Rectangle(5, 3),
                new Circle(2)
        );

        System.out.println("--------------------------------------------------------");

        for (Shape shape : shapes) {
            System.out.println("Area (Traditional): " + calculateArea(shape));
            System.out.println("Area (Enhanced): " + calculateAreaEnhanced(shape));
            System.out.println("--------------------------------------------------------");
        }

    }
}

