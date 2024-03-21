package org.example.LeetCode150;

public class LongestPalindromicSubstring {


    // s = "babad"

    // 1.way - Naive solution is Brute Force
    // Try all substrings is a valid palindrome, if so, check with max, return max at the end
    //  Time: O(n^3) , Space: O(1)


    // 2.way - more efficient
    //


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

}
