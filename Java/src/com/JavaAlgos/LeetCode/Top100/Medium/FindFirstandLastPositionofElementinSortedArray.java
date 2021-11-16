package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    /**
     * Given an array of integers nums sorted in non-decreasing order,
     * find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     *
     *
     * Constraints:
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums is a non-decreasing array.
     * -109 <= target <= 109
     * */

    /**
     * nums is increasing order with dups
     * <p>
     * What I am thinking:
     * <p>
     * They say "You must write an algorithm with O(log n) runtime complexity."
     * <p>
     * which really means that you want use "binary Search" for this
     * <p>
     * your given some sort of array so most likely your gonna use two pointers
     * <p>
     * We use an iterative binary search, where every time we find the target we put its index
     * into an array.
     * <p>
     * Things I forgot to do is look at this:
     * <p>
     * " starting and ending position of a given target value"
     * <p>
     * <p>
     * I misunderstood the question, I thought you would have to collect all the indexes where the value
     * was equal to the target
     **/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int curVal = nums[mid];
            if (curVal == target) {
                int high = Integer.MIN_VALUE;
                int low = Integer.MAX_VALUE;
                for (int i = start; i <= end; i++) {
                    if (nums[i] == target && i > high) {
                        high = i;
                    }
                    if (nums[i] == target && i < low) {
                        low = i;
                    }
                }
                return new int[]{low, high};
            } else if (target > curVal) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return new int[]{-1, -1};

    }


}
