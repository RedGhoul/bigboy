package com.JavaAlgos.LeetCode.Top100.Medium;

public class JumpGame {
    /**
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     * <p>
     * Return true if you can reach the last index, or false otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     * <p>
     * what I am thinking:
     * just need to return true if we can reach the end of the array
     * I think we could have some dfs action over here
     * recursive as well
     */

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{1000, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{1, 3, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        return canJumpHelper(0, 1, nums);
    }

    public static boolean canJumpHelper(int start, int end, int[] nums) {
        if (end >= nums.length - 1) return true;

        for (int i = start; i <= end; i++) {
            int curVal = nums[i];
            if (curVal == 0) continue;
            int newEnd = i + curVal;
            if (canJumpHelper(i + 1, newEnd, nums) == true) {
                return true;
            }
        }

        return false;
    }
}
