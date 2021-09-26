package com.JavaAlgos.LeetCode.Top100;
import java.util.*;
public class TwoSum {
    /*
        https://leetcode.com/problems/two-sum/
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]

        - Mistake
        First time failed due to me using ABS.
        It should always be target - current value, even if its negative
        Since then you would be negative + current = target

        Second mistake was using a second hash map, instead of storing the
        index of the number (currentval), that was used to create the key (target - currentval).

        - Things I should have done
        Should have considered negative values
        Don't use multiple hash maps everywhere, really thing about the
        things your are storing in the map
    * */

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5},-8))); //[2,4]
    }

    //bad version - uses too many hashes
    public static int[] twoSumV0(int[] nums, int target) {
        HashMap<Integer,Integer> mapping = new HashMap<>();
        HashMap<Integer,Integer> numIndexLoopUp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int currentVal = nums[i];
            if(mapping.containsKey(currentVal)){
                int firstIndex = i;
                int secondPair = mapping.get(currentVal);;
                int secondIndex = numIndexLoopUp.get(secondPair);
                return new int[] {firstIndex, secondIndex};
            }else{
                int diff = target-currentVal;
                mapping.put(diff, currentVal);
                numIndexLoopUp.put(currentVal,i);
            }
        }
        return new int[]{0,0};
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mapping = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int currentVal = nums[i];
            if(mapping.containsKey(currentVal)){
                int firstIndex = i;
                int secondIndex = mapping.get(currentVal);;
                return new int[] {firstIndex, secondIndex};
            }else{
                int diff = target-currentVal;
                mapping.put(diff, i);
            }
        }
        return new int[]{0,0};
    }
}
