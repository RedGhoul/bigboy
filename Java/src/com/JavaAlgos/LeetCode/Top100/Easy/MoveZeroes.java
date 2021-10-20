package com.JavaAlgos.LeetCode.Top100.Easy;

import java.util.Arrays;

public class MoveZeroes {
    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [0]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     *
     *
     * Follow up: Could you minimize the total number of operations do
     * **/
    public static void main(String[] args){
        int[] t1 = new int[] {0,1,0,1,0,22,3,4};
        moveZeroes(t1);
        System.out.println(Arrays.toString(t1));

        int[] t2 = new int[] {0,1,0,3,12};
        moveZeroes(t2);
        System.out.println(Arrays.toString(t2));


        int[] t3 = new int[] {0,0,0,0,12};
        moveZeroes(t3);
        System.out.println(Arrays.toString(t3));


        int[] t4 = new int[] {20,0,0,0,12};
        moveZeroes(t4);
        System.out.println(Arrays.toString(t4));
    }

    public static void moveZeroes(int[] nums) {
        if(nums[0] == 0 && nums.length == 1) return;

        int p1 = 0;
        int p2 = 1;

        for(int i = 0; i < nums.length; i++){
            int cur1 = nums[p1];
            if(p2 > nums.length-1) return;
            int cur2 = nums[p2];
            if(cur1 != 0){
                p1++;
                p2++;
            }else if(cur2 != 0){
                int temp = cur1;
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p1++;
                p2++;
            } else if(cur2 == 0){
                p2++;
            }
        }
    }
}
