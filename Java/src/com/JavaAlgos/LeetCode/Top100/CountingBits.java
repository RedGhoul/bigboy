package com.JavaAlgos.LeetCode.Top100;

public class CountingBits {
    /**
     *Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: [0,1,1]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * Example 2:
     *
     * Input: n = 5
     * Output: [0,1,1,2,1,2]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     *
     *
     * Constraints:
     *
     * 0 <= n <= 105
     *
     *
     * Follow up:
     *
     * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
     * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
     *
     *
     * What I am thinking:
     *
     * Loop through the array and figure out how ones are in "i"
     * **/
    public static void main(String[] args){

    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for(int i = 1; i <= num; i++){
            if((i & 1) == 0){
                // if it is even then its the previous even value
                // look at the example
                /*
                * 0 --> 0
                    1 --> 1
                    2 --> 10
                    3 --> 11
                    4 --> 100 - Even -> 4 >> 1 -> moving the 100 to the right and it become 10 which is the same as the 2
                    5 --> 101
                    *
                  the ">> 1" means shifting the bit by one to the right
                * */
                res[i] = res[i >> 1];
            }else{
                // if its odd then it is it's even counterpart plus 1
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }
}
