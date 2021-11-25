package com.JavaAlgos.LeetCode.Top100.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    /**
     * You are given a large integer represented as an integer array digits, where each
     * digits[i] is the ith digit of the integer. The digits are ordered from most significant to least
     * significant in left-to-right order. The large integer does not contain any leading 0's.
     *
     * Increment the large integer by one and return the resulting array of digits.
     *
     *
     *
     * Example 1:
     *
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     * Example 2:
     *
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     * Example 3:
     *
     * Input: digits = [0]
     * Output: [1]
     * Explanation: The array represents the integer 0.
     * Incrementing by one gives 0 + 1 = 1.
     * Thus, the result should be [1].
     * Example 4:
     *
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     *
     *
     * Constraints:
     *
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * digits does not contain any leading 0's.
     *
     *
     * What I am thinking:
     *
     * You add 1 to the end
     * If the resulting value is greater than 9
     * Take the extra 1 and add to the next number
     * Keep repeating till you reach the end
     *
     * Most Likely will just use an array List
     * **/
    public static void main(String[] args){
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,1,9,9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9,9})));
    }

    // the much slower version 4ms
    public static int[] plusOne(int[] digits) {
        if(digits.length == 0) return new int[]{};

        ArrayList<Integer> resulting = new ArrayList<>();
        boolean wasGreater = false;
        int startPos = digits.length-2;
        if(digits[digits.length-1]+ 1 > 9){
            wasGreater = true;
            resulting.add(0,0);
        }else{
            resulting.add(0,digits[digits.length-1]+ 1);
            if(digits.length == 1){
                return resulting.stream().mapToInt(i -> i).toArray();
            }
        }

        for(int i = startPos; i >= 0; i--){
            int curValue = digits[i];

            if(wasGreater){
                curValue = curValue + 1;
            }

            if(curValue > 9){

                resulting.add(0,0);
            }else{
                wasGreater = false;
                resulting.add(0,curValue);
            }
        }

        if(wasGreater){
            resulting.add(0,1);
        }

        return resulting.stream().mapToInt(i -> i).toArray();
    }


    // I think you might make things more complex than needed
    // less than 0 ms, used too much java magic on the sol at the top
    public static int[] plusOne2(int[] digits) {

        for(int i = digits.length-1; i <= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            // cause if it's greater than or equal to 9, this will result in a zero
            // it could be a chain of 9s
            digits[i] = 0;
        }
        // if we got to here that means everything was a 9 above and we need
        // to put one more 1 right in front so we just create a new array (which is already zero everywhere)
        // and put 1 in front

        int[] newResult = new int[digits.length+1];
        newResult[0] = 1;
        return newResult;
    }

}
