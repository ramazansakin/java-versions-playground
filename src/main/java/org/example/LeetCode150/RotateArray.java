package org.example.LeetCode150;

public class RotateArray {


    // Naive solution
    // 1.way with additional array; Space Complexity S(n), Time complexity O(2 * n) = O(n)
    public static void rotate(int[] nums, int k) {

        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotated[i];
        }
    }


    // 2.way reversing the array 1 by 1 k times; Space Complexity S(1), Time complexity O(n * k)
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // To handle cases where k > n

        // If k is greater than half the length of the array,
        // it's more efficient to rotate it backward
        if (k > n / 2) {
            k = n - k;
            for (int i = 0; i < k; i++) {
                rotateBackward(nums);
            }
        } else {
            for (int i = 0; i < k; i++) {
                rotateForward(nums);
            }
        }
    }

    private void rotateForward(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }

    private void rotateBackward(int[] nums) {
        int first = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = first;
    }

    // 3.way is more efficient way; Space Complexity S(1), Time complexity O(n * 2) => O(n)
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, n - 1); // Reverse the remaining n-k elements
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(arr, k);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
