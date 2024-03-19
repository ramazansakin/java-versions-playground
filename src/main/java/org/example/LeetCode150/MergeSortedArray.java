package org.example.LeetCode150;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1; // Index of last element in nums1
        int index2 = n - 1; // Index of last element in nums2
        int mergedIndex = m + n - 1; // Index where the next merged element should be placed

        // Merge elements from both arrays starting from the end
        while (index1 >= 0 && index2 >= 0) {
            // Compare elements from nums1 and nums2
            if (nums1[index1] > nums2[index2]) {
                nums1[mergedIndex--] = nums1[index1--];
            } else {
                nums1[mergedIndex--] = nums2[index2--];
            }
        }

        while (index2 >= 0) {
            nums1[mergedIndex--] = nums2[index2--];
        }
    }

}
