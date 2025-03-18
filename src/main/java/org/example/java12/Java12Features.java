package org.example.java12;

// 1. String Methods - indent and transform
public class Java12Features {

    public static void main(String[] args) {
        // String.indent() - adds or removes leading whitespace
        String text = "Hello\nJava\nWorld";
        String indented = text.indent(4);
        System.out.println(indented);

        // String.transform() - applies a function to a string
        String transformed = "hello, java".transform(String::toUpperCase);
        System.out.println(transformed); // HELLO, JAVA

        // Chain transformations
        String result = "  42  "
                .transform(String::strip)
                .transform(Integer::parseInt)
                .transform(x -> x * 2)
                .toString();
        System.out.println(result); // 84
    }

}
