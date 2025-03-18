package org.example.java15;

// 1. Text Blocks (Standard)
// 2. Records (Second Preview)
// 3. Sealed Classes (Preview)
public class Java15Features {

    public static void main(String[] args) {
        // 1. Text Blocks (Standardized)
        String html = """
                <html>
                    <body>
                        <h1>Java 15 Features</h1>
                        <p>Text blocks are now standard.</p>
                    </body>
                </html>
                """;

        System.out.println(html);

        // Using escape sequences and expressions in text blocks
        String name = "Java";
        String version = "15";
        String message = """
                Hello, %s %s!
                This is a text block with:
                    - No need for escaping double quotes: "example"
                    - Preserves indentation
                    - Supports escape sequences: \t tab \n newline
                """.formatted(name, version);

        System.out.println(message);

        // 2. Records (Second Preview)
        // 3. Sealed Classes (Preview)
        // These require --enable-preview flag in Java 15
    }

}
