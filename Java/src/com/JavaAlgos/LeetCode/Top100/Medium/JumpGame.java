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
     * NVM this is wrong lol - you made this wayyyy to complex
     *
     *
     * REALLY SIMPLE
     *
     * What is the max distance I can travel from this index ?
     *
     * If the place on the array your at is bigger then the
     * max distance you could ever travel then you will never reach the end
     *
     * If I am on the 407, and the max range I can get with any gass tank at 1KM internvals
     * is less then the distance I am already at, then I could never get here with those gas tanks

     */

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{1000, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{1, 3, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        return canJumpHelper(0, 1, nums);
    }

    public static boolean canJumpHelper(int start, int end, int[] nums) {
        if (end >= nums.length - 1) return true;

        for (int i = start; i <= end; i++) {
            int curVal = nums[i];
            if (curVal == 0 && i == start) return false;
            if (curVal == 0) continue;
            int newEnd = i + curVal;
            if (canJumpHelper(i + 1, newEnd, nums) == true) {
                return true;
            }
        }

        return false;
    }
}
