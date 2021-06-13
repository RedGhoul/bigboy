package com.JavaAlgos.Colt;

import java.util.Arrays;

public class MaxSubArraySum {
    /*
    * Write a function called maxSubarraySum which accepts an array
    * of integers and a number called "n".
    * The function should calculate the maximum sum of n
    * "consecutive" (the key term here) elements in the array
    * */

    public static void main(String[] args){
        System.out.println(findMax(new int[]{1,2,5,2,8,1,5},2));
        System.out.println(findMax(new int[]{1,2,5,2,8,1,5},4));
        System.out.println(findMax(new int[]{4,2,1,6},1));
        System.out.println(findMax(new int[]{4,2,1,6,2},4));
        System.out.println(findMax(new int[]{},4));
    }

    public static int findMax(int[] arrayIn, int windowSize){
        if(windowSize > arrayIn.length || arrayIn.length == 0) return 0;

        int start = 0;
        int end = windowSize-1;

        int curSum = 0;
        for(int i = start; i <= end; i++){
            curSum = curSum + arrayIn[i];
        }
        int maxSum = Integer.MIN_VALUE;
        if(curSum > maxSum){
            maxSum = curSum;
        }

        while(end <= arrayIn.length-1){
            start++;
            end++;
            if(end >= arrayIn.length){
                break;
            }
            int valueToSubtract = arrayIn[start-1];
            int valueToAdd = arrayIn[end];
            curSum = curSum + valueToAdd - valueToSubtract;
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
