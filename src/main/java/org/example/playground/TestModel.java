package org.example.playground;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.DoubleBinaryOperator;


public class TestModel {

    int id;
    String name;
    boolean isFine;

    public TestModel(int id, String name, boolean isFine) {
        this.id = id;
        this.name = name;
        this.isFine = isFine;
    }

    public static void main(String[] args) {

        List<TestModel> testModelList = Arrays.asList(new TestModel(1, "test1", true), new TestModel(2, "test2", true), new TestModel(3, "test3", false));

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

    }

}