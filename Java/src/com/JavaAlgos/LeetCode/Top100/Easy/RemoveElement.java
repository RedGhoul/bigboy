package com.JavaAlgos.LeetCode.Top100.Easy;

public class RemoveElement {
    /**
     * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of
     * ‘key’ in-place and return the new length of the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
     * Output: 4
     * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
     * <p>
     * Example 2:
     * <p>
     * Input: [2, 11, 2, 2, 1], Key=2
     * Output: 2
     * Explanation: The first two elements after removing every 'Key' will be [11, 1].
     * <p>
     * Really just draw it out and try to code it the way you would procedurally do it by hand
     * <p>
     * I think the pattern here is just one pointer being used as a marker, and the other being used as a guide
     * <p>
     * Time O(n)
     * Space O(1)
     **/

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));
        System.out.println(removeElement(new int[]{2, 11, 2, 2, 1}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }
}
