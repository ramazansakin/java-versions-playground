package org.example.playground;

public class BinarySearchSample {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4, 5, 6, 7, 8};

        int targetElement = 2;

        int firstIndex = findIndex(array, targetElement, true);
        int lastIndex = findIndex(array, targetElement, false);

        System.out.println("First Index: " + firstIndex);
        System.out.println("Last Index: " + lastIndex);
    }

    public static int findIndex(int[] array, int target, boolean isFirst) {
        int low = 0;
        int high = array.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                result = mid;

                if (isFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


    // root.value
    // root.left  - root.right

    // traverse left and check root.value > root.left.value
    // traverse right and check root.value < root.right.value

    class TreeNode {
        int value;
        TreeNode right;
        TreeNode left;

        public TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }

    }

    boolean checkValidBST(TreeNode root) {
        return checkValidBST(root, null, null);
    }

    boolean checkValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        // Check if current node's value is within the valid range
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }

        // Recursively check left and right subtrees
        return checkValidBST(node.left, min, node.value) && checkValidBST(node.right, node.value, max);
    }


}
