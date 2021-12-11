package com.JavaAlgos.LeetCode.Top100.Easy;

public class MaximumAverageSubarrayI {
    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     * <p>
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return
     * this value. Any answer with a calculation error less than 10-5 will be accepted.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Example 2:
     * <p>
     * Input: nums = [5], k = 1
     * Output: 5.00000
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= k <= n <= 105
     * -104 <= nums[i] <= 104
     * <p>
     * first thoughts
     * Sliding window
     * Move window forward - subtract the back & add the forward
     * then put it into the avg computation
     * <p>
     * Was right - ran into some edge cases  - was careless
     * <p>
     * Time complexity is O(N)
     * Space complexity is O(1) Cause we are doing everything in place
     **/
    public static void main(String[] args) {
        //System.out.println(findMaxAverage(new int[]{0,1,1,3,3},4));
        //System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        //System.out.println(findMaxAverage(new int[]{0,4,0,3,2},1));
        //System.out.println(findMaxAverage(new int[]{0,4,0,3,2},2));
        System.out.println(findMaxAverage(new int[]{-330, -44, -6, -77, -2}, 2));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (k == 1 && nums.length == 1) return nums[0];
        double max = 0;
        double curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum = curSum + nums[i];
        }
        max = curSum / k;
        int start = 0;
        for (int i = k; i <= nums.length; i++) {
            double curAvg = curSum / k;
            if (curAvg > max) {
                max = curAvg;
            }
            if (i < nums.length) {
                curSum = curSum - nums[start];
                curSum = curSum + nums[i];
                start++;
            }
        }

        return max;
    }

    // when your just asked to find the list of avgs
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return result;
    }
}
