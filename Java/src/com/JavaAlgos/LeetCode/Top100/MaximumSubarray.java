package com.JavaAlgos.LeetCode.Top100;

import java.util.Arrays;

public class MaximumSubarray {
    /**
     *
     *Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     *
     * A subarray is a contiguous part of an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 1
     * Example 3:
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     *
     * Problem Key:
     * You don't need to go through all the permutations !!
     * Got to just set the current running Sum to Zero when it becomes less
     * than or equal to zero, cause there is no way you can get the biggest sum starting
     * from there.
     * And got to just keep track of what the biggest running sum was. Then return that.
     *
     * Things that could be improved:
     * - Look through your code as much as possible before running
     *
     * Things that learned:
     * The solution isn't always complex, be careful not to over complicate things
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * **/

    public static void main(String[] args){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-2,-5,5}));
        System.out.println(maxSubArray(new int[]{2,-34,-2}));
        System.out.println(maxSubArray(new int[]{0,-34,-2}));
    }

    public static int maxSubArray(int[] nums) {
        int tempMax = 0;
        int curMax = Integer.MIN_VALUE;

        for(int i =0; i < nums.length; i++){
            tempMax = tempMax + nums[i];
            if(tempMax > curMax){
                curMax = tempMax;
            }
            if(tempMax <= 0){
                tempMax = 0;
            }
        }
        return curMax;
    }

}
