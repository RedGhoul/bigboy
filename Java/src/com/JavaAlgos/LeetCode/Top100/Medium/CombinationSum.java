package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique
     * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * <p>
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are
     * unique if the frequency of at least one of the chosen numbers is different.
     * <p>
     * It is guaranteed that the number of unique combinations that sum up to target is less than
     * 150 combinations for the given input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     * <p>
     * Input: candidates = [2], target = 1
     * Output: []
     * Example 4:
     * <p>
     * Input: candidates = [1], target = 1
     * Output: [[1]]
     * Example 5:
     * <p>
     * Input: candidates = [1], target = 2
     * Output: [[1,1]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * All elements of candidates are distinct.
     * 1 <= target <= 500
     * <p>
     * I am thinking exhaustive search of a tree, but then how I am going to keep track of the duplicate answers ?
     * Same thing we did in the dp you-tube video
     * <p>
     * It's asking for combinations, so backtracking ?? <- YESSSS - Draw the fuckin treeeeee
     * <p>
     * back tracking in a sort of nut shell
     * <p>
     * big loop:
     * 1 add some stuff to bag
     * 2 recursive call to do some stuff on that bag
     * 3 remove what you added to that bag in step 2
     *
     *
     * christ all mighty fml
     **/
    public static void main(String[] args) {
        combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalAnswers = new ArrayList<>();
        List<Integer> curGroup = new ArrayList<>();
        combinationSumHelper(finalAnswers, curGroup, candidates, target, 0);
        return finalAnswers;
    }

    public static void combinationSumHelper(List<List<Integer>> finalAnswers, List<Integer> curGroup, int[] candidates, int target, int start) {
        if (target == 0) {
            finalAnswers.add(new ArrayList<>(curGroup));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int tempVal = target - candidates[i];
            if (tempVal >= 0) {
                curGroup.add(candidates[i]);
                combinationSumHelper(finalAnswers, curGroup, candidates, tempVal, i);
                /**
                 * You put the "i" in there because you don't want any more repeated values than necessary
                 *
                 * I already did everything with a 2 (i = 0) so I'm going to keep starting with a 3 (i = 1) this time
                 * when i do the recurstion down, this is why I don't get anymore dup arrays in the final array
                 * **/

                curGroup.remove(curGroup.size() - 1);
            }
        }
    }
}
