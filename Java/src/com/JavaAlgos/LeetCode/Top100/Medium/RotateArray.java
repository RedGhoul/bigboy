package com.JavaAlgos.LeetCode.Top100.Medium;

public class RotateArray {
    /**
     *
     *Given an array, rotate the array to the right by k steps, where k is non-negative.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     *
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     *
     *
     * Follow up:
     *
     * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     *
     *
     * What I am thinking - we just use a double for loop
     *
     * the modulu oprator just gives you the reminder. If the reminder is 0.012 it
     * just gives you back the orignial number.
     *
     * We would want to see how much would remain if we had a K value of 200 on a array size of 10
     * if I rotated the array 200 times how much would be left to actually rotate
     *
     * really look at the question and move things around, and see the pattern
     *
     * 1) reverse the array
     * 2) reverse the center to the end
     * 3) reverse the start to the center
     *
     * Could I solve this ? No - the approach was out of left field for me
     * **/

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
