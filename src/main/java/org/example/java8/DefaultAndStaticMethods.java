package org.example.java8;

interface Shape {
    double calculateArea();

    static double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}

class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class DefaultAndStaticMethods {

    public static void main(String[] args) {

        Circle circle = new Circle(5);
        System.out.println("Area of the circle: " + circle.calculateArea());
        System.out.println("Perimeter of the circle: " + Shape.calculatePerimeter(circle.calculateArea()));

        System.out.println("------------------------------------------------------------------------");

        Vehicle car = new Car("Sedan");
        Vehicle bicycle = new Bicycle("Mountain Bike");

        System.out.println("Car type: " + car.getType());
        System.out.println("Number of wheels for car: " + car.getNumberOfWheels());

        System.out.println("Bicycle type: " + bicycle.getType());
        System.out.println("Number of wheels for bicycle: " + bicycle.getNumberOfWheels());

    }

}


interface Vehicle {
    // Default method to get the number of wheels
    default int getNumberOfWheels() {
        return 4; // Default value for most vehicles
    }

    // Abstract method to get the type of vehicle
    String getType();
}

class Car implements Vehicle {
    private String type;

    Car(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}


class Bicycle implements Vehicle {
    private String type;

    Bicycle(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    // Override the default method for Bicycle
    @Override
    public int getNumberOfWheels() {
        return 2; // Bicycles have 2 wheels
    }
}



