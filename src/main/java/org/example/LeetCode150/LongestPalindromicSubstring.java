package org.example.LeetCode150;

public class LongestPalindromicSubstring {


    // s = "babad"

    // 1.way - Naive solution is Brute Force
    // Try all substrings is a valid palindrome, if so, check with max, return max at the end
    //  Time: O(n^3) , Space: O(1)


    // 2.way - more efficient
    // it can be dynamic programming approach or like below
    // dynamic programming approach is efficient but its looking little bit more tricky :)

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = isPalindromic(s, i, i);
            int even = isPalindromic(s, i, i + 1);
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int isPalindromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println("Longest palindrome substring: " + solution.longestPalindrome(s)); // Output: "bab" or "aba"
    }

}
