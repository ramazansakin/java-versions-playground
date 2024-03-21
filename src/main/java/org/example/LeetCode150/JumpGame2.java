package org.example.LeetCode150;

public class JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int currentEnd = 0; // farthest point that can be reached with current number of jumps
        int farthest = 0; // farthest point that can be reached with one more jump

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) { // reached the end of the current jump
                jumps++;
                currentEnd = farthest;
                if (farthest >= n-1) return jumps;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 solution = new JumpGame2();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Output for nums1: " + solution.jump(nums1)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Output for nums2: " + solution.jump(nums2)); // Output: 2
    }

}
