package com.JavaAlgos.LeetCode.Top100.Medium;

public class JumpGame2 {
    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * You can assume that you can always reach the last index.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: nums = [2,3,0,1,4]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * <p>
     * <p>
     * What I am thinking:
     * <p>
     * Same thing as jump game 1 except your looking for minimum number of jumps to get there
     * <p>
     * Could do the same things as jump game 1 except hold a collection of the stuff you found,
     * then do a sort to find the smallest one ?
     * <p>
     * Or just keep track of the smallest one, and return it at the end ?
     **/

    public int jump(int[] nums) {
        return 0;
    }
}
