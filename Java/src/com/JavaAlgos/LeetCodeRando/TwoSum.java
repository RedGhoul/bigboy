package com.JavaAlgos.LeetCodeRando;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,3},6)));
    }
/*
* Leet Code Easy
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
* You can return the answer in any order.
*
* TIME: O(N)
* More memory usage and less time
*
*
* You could also sort and then do a two pointer
* less memory usage and more time
*
* Sort algo is O(n*log(n))
*
* */
    public static int[] twoSum(int[] nums, int target){
        if(nums.length == 0) return new int[]{};
        HashMap<Integer,Integer> mapper = new HashMap<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        if(nums.length == 2){
            return new int[]{0,1};
        }
        for(int i = 0; i < nums.length; i++){
            int valueKey = target - nums[i];
            int curValue = nums[i];

            if(!indexMap.containsKey(curValue)){
                indexMap.put(curValue,i);
            }


            if(mapper.containsKey(curValue)){
                int firstPoint = i;
                int secPoint =  indexMap.get(mapper.get(curValue));
                return new int[]{secPoint,firstPoint};
            }else{
                mapper.put(valueKey,curValue);
            }
        }

        return new int[]{};
    }
}
