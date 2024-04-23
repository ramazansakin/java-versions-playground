package org.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamExercise {

    private static int testNumber = 1000000;

    public static void main(String[] args) {
        // Generate sample data
        List<Integer> grades = generateRandomGrades(testNumber); // Generate a large dataset

        // Test performance with parallel streams
        long startTime = System.nanoTime();
        double averageGradeParallel = calculateAverageGradeParallel(grades);
        long endTime = System.nanoTime();
        long parallelDuration = endTime - startTime;

        System.out.println("Average Grade (Parallel): " + averageGradeParallel);
        System.out.println("Time taken for one item to process with parallel streams: " + parallelDuration / testNumber + " milliseconds");

        // Test performance with sequential streams
        startTime = System.nanoTime();
        double averageGradeSequential = calculateAverageGradeSequential(grades);
        endTime = System.nanoTime();
        long sequentialDuration = endTime - startTime;

        System.out.println("Average Grade (Sequential): " + averageGradeSequential);
        System.out.println("Time taken for one item to process with sequential streams: " + sequentialDuration / testNumber + " milliseconds");

        // Compare the elapsed time
        if (parallelDuration < sequentialDuration) {
            System.out.println("Parallel streams were faster.");
        } else if (parallelDuration > sequentialDuration) {
            System.out.println("Sequential streams were faster.");
        } else {
            System.out.println("Both approaches took the same amount of time.");
        }
    }

    // Method to generate a list of random grades
    private static List<Integer> generateRandomGrades(int numStudents) {
        List<Integer> grades = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            grades.add(random.nextInt(101)); // Grades range from 0 to 100
        }
        return grades;
    }

    // Method to calculate average grade using parallel streams
    private static double calculateAverageGradeParallel(List<Integer> grades) {
        return grades.parallelStream() // Convert list to parallel stream
                .mapToInt(Integer::intValue) // Convert Integer to int
                .average() // Calculate average
                .getAsDouble(); // Get the result as double
    }

    // Method to calculate average grade using sequential streams
    private static double calculateAverageGradeSequential(List<Integer> grades) {
        return grades.stream() // Convert list to sequential stream
                .mapToInt(Integer::intValue) // Convert Integer to int
                .average() // Calculate average
                .getAsDouble(); // Get the result as double
    }

}
