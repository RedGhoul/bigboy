package com.JavaAlgos.LeetCode.Top100.Easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /**
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -231 <= nums[i] <= 231 - 1
     *
     *
     * Problem Key:
     * Hash Maps are the key, kind of like find the biggest element
     *
     * Things I learned:
     * Even simple questions can have twists
     * There is a O(n) time & space complexity solution
     * https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
     *
     * Pattern
     * Hashmaps can solve anything
     *
     * Pattern for O(n) time & space solution:
     * Assuming stuff and going through a list
     *
     *
     * **/
    public static void main(String[] args){

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> bag = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int currentInt = nums[i];
            if(!bag.containsKey(currentInt)){
                bag.put(currentInt, 1);
            }else{
                bag.put(currentInt, bag.get(currentInt)+1);
            }
        }
        int maxCount = Integer.MIN_VALUE;
        int maxKey = 0;
        for(Map.Entry<Integer,Integer> entry : bag.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
