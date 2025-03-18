package org.example.java11;

// 1. String API Enhancements
public class StringEnhancementsExample {

    public static void main(String[] args) {
        // isBlank() - returns true if string is empty or contains only whitespace
        String emptyString = "";
        String whitespaceString = "   \t\n";
        System.out.println("Empty string is blank: " + emptyString.isBlank()); // true
        System.out.println("Whitespace string is blank: " + whitespaceString.isBlank()); // true

        // lines() - splits string by line terminators and returns a Stream
        String multilineString = "Line 1\nLine 2\nLine 3";
        multilineString.lines()
                .forEach(System.out::println);

        // strip(), stripLeading(), stripTrailing() - like trim() but Unicode-aware
        String textWithWhitespace = "  \u2005Hello World\u2005  ";
        System.out.println("Original: '" + textWithWhitespace + "'");
        System.out.println("strip(): '" + textWithWhitespace.strip() + "'");
        System.out.println("stripLeading(): '" + textWithWhitespace.stripLeading() + "'");
        System.out.println("stripTrailing(): '" + textWithWhitespace.stripTrailing() + "'");

        // repeat(n) - repeats the string n times
        String star = "*";
        System.out.println(star.repeat(10)); // **********

        // Example of a text formatter using the new methods
        String formatted = formatText("  This is\n   some text  \nwith irregular spacing\n");
        System.out.println("Formatted text:\n" + formatted);
    }

    private static String formatText(String text) {
        return text.lines()
                .map(String::strip)
                .filter(line -> !line.isBlank())
                .map(line -> "> " + line)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
    }

}
