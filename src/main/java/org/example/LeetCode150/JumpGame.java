package org.example.LeetCode150;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int currentEnd = nums[0];
        if (nums.length == 1) return true; // think about the edge-cases at the end

        for (int i = 1; i <= currentEnd; i++) {
            currentEnd = Math.max(currentEnd, i + nums[i]);
            if(currentEnd >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();

        int[] nums1 = {2, 3, 0, 1, 4};
        System.out.println("Output for nums1: " + solution.canJump(nums1)); // Output: 2

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Output for nums2: " + solution.canJump(nums2)); // Output: 2

    }

}