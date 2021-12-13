package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.HashMap;

public class LongestSubarraywithOnesafterReplacement {
    /**
     * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
     * find the length of the longest contiguous subarray having all 1s.
     * <p>
     * Example 1:
     * <p>
     * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
     * Output: 6           A           B
     * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
     * Example 2:
     * <p>
     * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
     * Output: 9
     * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
     * <p>
     * Time complexity is O(n) - we go over the whole thing once
     * Space complexity is O(1) - since we don't allocate anything
     **/

    public static int findLength(int[] arr, int k) {
        int maxLength = 0;
        int start = 0;
        int numberOfOnes = 0;
        HashMap<Integer, Integer> bag = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            if (curVal == 1) {
                numberOfOnes++;
            }

            int windowSize = i - start + 1;
            int numberOfZeros = windowSize - numberOfOnes;

            if (numberOfZeros > k) {
                int toReplace = arr[start];
                if (toReplace == 1) {
                    numberOfOnes--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, windowSize);

        }

        return maxLength;
    }
}
