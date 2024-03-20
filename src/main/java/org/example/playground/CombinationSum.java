package org.example.playground;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int target, int start) {
        if (target < 0) {
            return; // Stop if the target becomes negative
        }
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if ( i > 0 &&  candidates[i] == candidates[i - 1])
                continue;

            currentList.add(candidates[i]);
            backtrack(result, currentList, candidates, target - candidates[i], i + 1); // Allow reuse of current element
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

}