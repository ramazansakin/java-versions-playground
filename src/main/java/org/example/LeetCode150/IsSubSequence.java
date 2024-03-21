package org.example.LeetCode150;

public class IsSubSequence {

    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            // If characters match, move pointer for string s
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            // Always move pointer for string t
            tPointer++;
        }
        // If all characters of s have been found in t in order, return true
        return sPointer == s.length();
    }

    public static void main(String[] args) {
        IsSubSequence solution = new IsSubSequence();

        String s1 = "abc", t1 = "ahbgdc";
        System.out.println("Output for s1: " + solution.isSubsequence(s1, t1)); // Output: true

        String s2 = "axc", t2 = "ahbgdc";
        System.out.println("Output for s2: " + solution.isSubsequence(s2, t2)); // Output: false
    }

}
