package com.JavaAlgos.LeetCode.Top100.Easy;
import java.util.*;
public class ContainsDuplicate {
    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,2,3,4]
     * Output: false
     * Example 3:
     *
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     * Hash Map All the way down
     * **/

    public static void main(String[] args){

    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> bag = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            int curVal = nums[i];
            if(bag.containsKey(curVal)){
                return true;
            }else{
                bag.put(curVal,1);
            }
        }
        return false;

    }
}
