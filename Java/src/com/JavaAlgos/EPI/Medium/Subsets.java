package com.JavaAlgos.EPI.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    /**
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * <p>
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     * <p>
     * Input: nums = [0]
     * Output: [[],[0]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * All the numbers of nums are unique.
     * <p>
     * Basically the whole thing is about
     * Find subsets when I add a thing
     * Find subsets when I remove a thing
     * <p>
     * Time complexity is:
     * Times the recursive function is called is: 2^N since 2 times per method call
     * Work done in each function call is O(N)
     * <p>
     * Total becomes O(N*2^N)
     * <p>
     * Space complexity:
     * 2^n subsets
     * each one is at most n/2
     * total is O(N*2^N)
     **/

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> nums2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> cand = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        subSetHelper(nums2, cand, answer, 0);
        return answer;
    }

    public static void subSetHelper(List<Integer> nums, List<Integer> cand,
                                    List<List<Integer>> answer, int curPointer) {
        if (curPointer == nums.size()) {
            answer.add(new ArrayList<>(cand)); // cause you need to make a new copy
            return;
        }

        cand.add(nums.get(curPointer));
        subSetHelper(nums, cand, answer, curPointer + 1);
        cand.remove(cand.size() - 1);
        subSetHelper(nums, cand, answer, curPointer + 1);
    }
}
