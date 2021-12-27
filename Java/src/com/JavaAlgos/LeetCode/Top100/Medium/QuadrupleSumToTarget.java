package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.List;

public class QuadrupleSumToTarget {
    /**
     * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
     * whose sum is equal to the target number.
     * <p>
     * Example 1:
     * <p>
     * Input: [4, 1, 2, -1, 1, -3], target=1
     * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
     * Explanation: Both the quadruplets add up to the target.
     * Example 2:
     * <p>
     * Input: [2, 0, -1, 1, -2, 2], target=2
     * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
     * Explanation: Both the quadruplets add up to the target.
     * <p>
     * What I thought:
     * Sort Array
     * For loop
     * newTarget = target - x
     * <p>
     * for loop
     * newTarget = newTarget - y
     * <p>
     * while loop
     * then try to find newTarget = Left + Right
     * to move left right pointers for the sum to be zero
     * if you find something, put it into the array of arrays
     * <p>
     * What they said would work:
     * Sort Array
     * For loop for first number (x)
     * <p>
     * For loop for second number (y)
     * <p>
     * while loop to move the left right pointers
     * so that the total sum = x + y + left + right
     * if you find something, put it into the array of arrays
     * <p>
     * For both cases:
     * Time : O(N^3) - cause of the three nested for loops
     * Space : O(N) - best case sort takes O(N) Space
     **/

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();


        return quadruplets;
    }
}
