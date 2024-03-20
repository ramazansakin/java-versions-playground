package org.example.java13;

public class SwitchExpressionWithYield {

    public static void main(String[] args) {

        int day = 3;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> {
                if (day > 0 && day < 8) {
                    yield "Invalid Day";
                } else {
                    yield "Unknown Day";
                }
            }
        };

        System.out.println("Day Type: " + dayType);
    }

}
