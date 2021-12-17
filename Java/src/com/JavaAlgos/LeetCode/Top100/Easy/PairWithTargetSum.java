package com.JavaAlgos.LeetCode.Top100.Easy;

import java.util.Arrays;

public class PairWithTargetSum {
    /**
     * Given an array of "sorted" (Key!!!) numbers and a target sum, find a pair in the array whose sum is equal to the given target.
     * <p>
     * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
     * <p>
     * Example 1:
     * <p>
     * Input: [1, 2, 3, 4, 6], target=6
     * Output: [1, 3]
     * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
     * Example 2:
     * <p>
     * Input: [2, 5, 9, 11], target=11
     * Output: [0, 2]
     * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
     * <p>
     * Time complexity: O(n) - we go through the array
     * Space complexity: O(1) - not allocating anything
     * <p>
     * Could also use the hash map way to do this,
     * where we store target - curval as the key, and curval as the value
     * that time complexity would be O(n)
     * and the space complexity would be O(n) cause of the hash map
     **/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(search(new int[]{2, 5, 9, 11}, 11)));
    }

    public static int[] search(int[] arr, int targetSum) {
        if (arr == null) return new int[]{-1, -1};
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int startVal = arr[start];
            int endVal = arr[end];
            int sum = startVal + endVal;
            if (sum == targetSum) return new int[]{start, end};
            if (sum > targetSum) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
}
