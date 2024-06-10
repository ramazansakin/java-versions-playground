package org.example.playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.DoubleBinaryOperator;


public class TestModel implements Comparable<TestModel> {

    int id;
    String name;
    boolean isFine;

    public TestModel(int id, String name, boolean isFine) {
        this.id = id;
        this.name = name;
        this.isFine = isFine;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isFine=" + isFine +
                '}';
    }

    @Override
    public int compareTo(TestModel o) {
        return this.getName().compareTo(o.getName());
    }

    public static void main(String[] args) {

        List<TestModel> testModelList = Arrays.asList(new TestModel(4, "test4", false), new TestModel(1, "test1", true), new TestModel(2, "test2", true), new TestModel(3, "test3", false));

        // Below line ll not work if related model class didn't implement Comparable interface !
        // Collections.sort(testModelList);

        DoubleAccumulator test = new DoubleAccumulator(new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left + right;
            }
        }, 0);

        // Lambda version impl of above sample DoubleAccumulator
        DoubleAccumulator test2 = new DoubleAccumulator((left, right) -> left + right, 0);


        // Convert the List to an array
        // 1.way
        TestModel[] testModelArray = testModelList.toArray(new TestModel[0]);

        // 2.way
        TestModel[] testModelArray2 = new TestModel[testModelList.size()];
        testModelList.toArray(testModelArray2); // fill the array

        System.out.println("-- Before parallel sorting ------------------------");
        testModelList.stream().forEach(System.out::println);

        System.out.println("-- After Parallel Sorting ------------------------");
        Arrays.parallelSort(testModelArray);

        Arrays.stream(testModelArray).forEach(System.out::println);

    }

}