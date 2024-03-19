package org.example.LeetCode150;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
            nums[count++] = nums[i];
        }
        return count;
    }

}
