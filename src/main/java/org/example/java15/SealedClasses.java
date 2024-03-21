package org.example.java15;

// Sealed interface
sealed interface Shape permits Circle, Rectangle {
    double area(); // Abstract method
}

// Sealed class Circle implementing Shape
final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Sealed class Rectangle implementing Shape
final class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}


public class SealedClasses {

    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        System.out.println("Area of circle: " + circle.area());

        Shape rectangle = new Rectangle(3.0, 4.0);
        System.out.println("Area of rectangle: " + rectangle.area());
    }
}

