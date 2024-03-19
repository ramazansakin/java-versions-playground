package org.example.java12;

public class SwitchExpressionsExample {

    public static void main(String[] args) {
        int dayOfWeek = 3;

        // Old switch statement
        String dayType = getDayTypeOld(dayOfWeek);
        System.out.println("Old switch statement: " + dayType);

        // New switch expression
        String dayTypeExpression = getDayTypeExpression(dayOfWeek);
        System.out.println("Switch expression: " + dayTypeExpression);
    }

    // Old switch statement
    public static String getDayTypeOld(int dayOfWeek) {
        String dayType;
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Weekday";
                break;
            case 6:
            case 7:
                dayType = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        }
        return dayType;
    }

    // New switch expression
    public static String getDayTypeExpression(int dayOfWeek) {
        return switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
        };
    }

}