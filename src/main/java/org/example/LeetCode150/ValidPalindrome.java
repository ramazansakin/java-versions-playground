package org.example.LeetCode150;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = cleanedString.length() - 1;
        int mid = (start + end + 1) / 2;

        for (int i = 0; i < mid; i++) {
            if (cleanedString.charAt(start++) != cleanedString.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "race a car";

        System.out.println("Is palindrome : " + new ValidPalindrome().isPalindrome(s));

    }

}
