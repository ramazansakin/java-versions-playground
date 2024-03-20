package org.example.java13;

public class TextBlocksSample {
    public static void main(String[] args) {
        String sqlQuery = """
                    SELECT *
                    FROM employees
                    WHERE department = 'IT'
                    ORDER BY last_name
                """;

        System.out.println(sqlQuery);
    }

}