package org.example.java14;

public class PatternMatchingAndRecords {

    public static void main(String[] args) {
        // Create an array of different types of animals
        Object[] animals = {
                new Dog("Buddy", "Golden Retriever"),
                new Cat("Whiskers", "Tabby"),
                new Parrot("Polly", "Green")
        };

        // Iterate over the array and perform actions based on the type of animal
        for (Object animal : animals) {
            if (animal instanceof Dog d) {
                System.out.println("Dog: " + d.name() + ", Breed: " + d.breed());
                d.bark();
            } else if (animal instanceof Cat c) {
                System.out.println("Cat: " + c.name() + ", Breed: " + c.breed());
                c.meow();
            } else if (animal instanceof Parrot p) {
                System.out.println("Parrot: " + p.name() + ", Color: " + p.color());
                p.speak();
            } else {
                System.out.println("Unknown animal");
            }
        }
    }

    // Define record classes for different types of animals
    record Dog(String name, String breed) {
        void bark() {
            System.out.println("Woof!");
        }
    }

    record Cat(String name, String breed) {
        void meow() {
            System.out.println("Meow!");
        }
    }

    record Parrot(String name, String color) {
        void speak() {
            System.out.println("Squawk!");
        }
    }

}
