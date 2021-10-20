package com.JavaAlgos.LeetCode.Top100.Easy;

public class SingleNumber {

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     * Example 3:
     *
     * Input: nums = [1]
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * Each element in the array appears twice except for one element which appears only once.
     *
     *
     * Problem Key:
     * Either use bit wise manipulations (XOR) or use the "Set" data structure
     *
     * XOR
     * if same returns 0, if diff return 1
     * If you XOR all the numbers in the array, they end up cancelling each other out.
     * EXCEPT for the one number that doesn't have a counter part
     * Cause XORing two of the same numbers ends up with a zero.
     * **/

    public static void main(String[] args){
        System.out.println(singleNumber(new int[]{2,2,1}));
        //System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        //System.out.println(singleNumber(new int[]{1}));
    }

//    public static int singleNumber(int[] nums) {
//        int sum = 0;
//        int switchNum = 1;
//        for(int i = 0; i < nums.length; i++){
//            sum = sum + nums[i];
//        }
//        int lastVal = 0;
//        for(int i =0; i < nums.length;i++){
//            int curNum = nums[i];
//            int temp = curNum + curNum;
//            sum = sum - temp;
//            lastVal =
//
//        }
//
//
//
//        return Math.abs(answer);
//    }

    public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        int finalAnswer = 0;
        for(int i =0; i < nums.length; i++){
             finalAnswer = finalAnswer ^ nums[i];
        }
        return finalAnswer;
    }
}
