package com.JavaAlgos.LeetCode.Top100.Easy;
import java.util.*;
public class IntersectionofTwoArraysII {
    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Explanation: [9,4] is also accepted.
     *
     *
     * Constraints:
     *
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     *
     *
     * Follow up:
     *
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
     * into the memory at once?
     *
     * What I am thinking:
     *
     * Hashmaps all the way down. Create one hashmap of the biggest array.
     * Then use the other array to go through the hashmap you made previously
     * **/
    public static void main(String[] args){
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5,303,2,2,2,2,2}, new int[]{9,4,9,8,303,4,303,303,2,2,2,2,2})));
        System.out.println(Arrays.toString(intersect(new int[]{}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        HashMap<Integer,Integer> mainMap = new HashMap<>();
        int[] mapInt;
        int[] minInt;
        if(nums1.length >= nums2.length){
            mapInt = nums1;
            minInt = nums2;
        }else{
            mapInt = nums2;
            minInt = nums1;
        }

        for(int i = 0; i < mapInt.length; i++){
            int curVal = mapInt[i];
            if(mainMap.containsKey(curVal)){
                mainMap.put(curVal,mainMap.get(curVal)+1);
            }else{
                mainMap.put(curVal,1);
            }
        }
        ArrayList<Integer> commonVals = new ArrayList<Integer>();
        for(int i = 0; i < minInt.length; i++){
            int curVal = minInt[i];
            if(mainMap.containsKey(curVal)){
                if(mainMap.get(curVal) > 0){
                    mainMap.put(curVal, mainMap.get(curVal)-1);
                    commonVals.add(curVal);
                }
            }
        }
        int[] ret = new int[commonVals.size()];
        for(int i = 0; i < commonVals.size();i++){
            ret[i] = commonVals.get(i);
        }
        return ret;
        //return commonVals.stream().mapToInt(i -> i).toArray(); stream api is slow and takes more memory
    }
}
