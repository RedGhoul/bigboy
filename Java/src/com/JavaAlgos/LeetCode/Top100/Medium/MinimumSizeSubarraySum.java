package com.JavaAlgos.LeetCode.Top100.Medium;

public class MinimumSizeSubarraySum {
    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     * contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     * <p>
     * Example 1:
     * <p>
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * Example 2:
     * <p>
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * Example 3:
     * <p>
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * <p>
     * <p>
     * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time
     * complexity is O(n log(n)).
     * <p>
     * Trying to optimize around the target. Trying to grow and shrink it.
     * Shrink continuously (aka use a while loop) - if the curSum is too high
     * Grow if the curSum is too low
     * <p>
     * Some time in these sliding window problems you end up having to do nested loops
     * to move the end of the window
     * <p>
     * It still ends up having a time complexity of O(N)
     * <p>
     * You might be thinking why this isn't O(n^2) that is because the other for loop goes over all the elements
     * just once
     * <p>
     * And the inner for loop worst case goes through the elements just once
     * there for its more like two for loops in succession O(n+n) rather than one inside another
     * <p>
     * Space complexity is just O(1) since we aren't allocating a new array
     * <p>
     * You were on the right track, didn't figure out the innear loop part of it
     * What I learned:
     * You can have an inner loop and still have O(N) time complexity
     * ONLY if both loop go over the same elements only once
     **/

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int curSum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            curSum = curSum + nums[end];

            while (curSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                curSum = curSum - nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
