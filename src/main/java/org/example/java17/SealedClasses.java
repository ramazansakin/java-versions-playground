package org.example.java17;

sealed class Document permits TextDocument, SpreadsheetDocument {
    private final String name;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Printing document: " + getName());
    }
}

final class TextDocument extends Document {
    private final String content;

    public TextDocument(String name, String content) {
        super(name); // Call the parent constructor with the name
        this.content = content;
    }

    @Override
    public String getName() {
        return "Text Document: " + super.getName() + " and content : " + content;
    }
}

final class SpreadsheetDocument extends Document {
    private final int[][] data;

    public SpreadsheetDocument(String name, int[][] data) {
        super(name); // Call the parent constructor with the name
        this.data = data;
    }

    @Override
    public String getName() {
        return "Spreadsheet: " + super.getName() + " and data : \n" + SealedClasses.arrayToString(data);
    }
}

public class SealedClasses {
    public static void main(String[] args) {
        Document textDoc = new TextDocument("MyTextFile", "This is some text content.");
        textDoc.print(); // Output: Printing document: Text Document: MyTextFile

        Document spreadsheet = new SpreadsheetDocument("SalesData", new int[][]{{1, 2, 3}, {4, 5, 6}});
        spreadsheet.print(); // Output: Printing document: Spreadsheet: SalesData

        // Trying to create an unauthorized subclass would result in a compile-time error.
        // IllegalDocument illegalDoc = new IllegalDocument("Error");
    }

    public static String arrayToString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                if (j < array[i].length - 1) {
                    sb.append(" "); // Separate elements within a row with space
                }
            }
            if (i < array.length - 1) {
                sb.append("\n"); // Separate rows with newline
            }
        }
        return sb.toString();
    }

}
