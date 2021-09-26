package com.JavaAlgos.LeetCode.Rando;
/*
* LEET CODE EASY - 26 - Remove Duplicates from Sorted Array
*
*
* */
public class RemoveDupsFromSortedArray {
    /*
    * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
    * each unique element appears only once. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the
    * result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
    * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
    *
    *
    * */
    public static void main(String[] args){

        removeDuplicates(new int[] {1,2,3});
    }

    // WTF did you learn from this ?
    /*
    * Have good edge cases
    * Don't over complicate this stuff
    * Keep it simple
    *
    * Some times the dumbest straight forward solution is the right one
    *
    * Properly understand what the question is asking you to output
    * K is the NUMBER of elements !! not the INDEX of last element
    * */

    public static int removeDuplicates(int[] num){
        if(num.length == 0) return 0;

        int A = 0;
        for(int B = 1; B < num.length; B++){
            if(num[A] != num[B]){
                A++;
                num[A] = num[B]; // just over write it
            }
        }
        return A;
    }
    /*
    *
    * Input: nums = [0,0,1,1,1,2,2,3,3,4]
    *               [0,1,0,1,1,2,2,3,3,4]
    *
      Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    * */
    public static int removeDuplicatesFalse(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        if(nums.length == 2){
            if(nums[0] == nums[1]){
                return 1;
            }else if (nums[0] > nums[1]){
                swap(0,1,nums);
            }
        }

        int a = 1;
        int b = a + 1;
        for(int i = 0; i < nums.length-2; i++){
            int curValueA = nums[a];
            int curValueB = nums[b];

            if(curValueB > curValueA && (b-a > 1)){
                if(i != 0){
                    a++;
                }
                swap(a,b,nums);
            }
            b++;
        }
        if(nums[0] == nums[1]) {
            return 1;
        }
        return a+1;
    }

    public static void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
