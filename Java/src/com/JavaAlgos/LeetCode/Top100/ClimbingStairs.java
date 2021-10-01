package com.JavaAlgos.LeetCode.Top100;

public class ClimbingStairs {
    /**
     *You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     * n = 4
     * 1 + 1 + 1 + 1
     * 2 + 2
     * 1 + 1 + 2
     * 2 + 1 + 1
     * 1 + 2 + 1
     *
     * n = 5
     *
     * I was on the right track, 80% of the way there yay !!!
     *
     * Problem Key:
     * Could have done this using 3 approaches:
     * - Iterative
     * - Recursive
     * - Dynamic programming
     *
     * The number of ways to get to the Nth step is the summation
     * of the ways to get to the two steps behind the Nth step.
     *
     * You can see this if write out the 4th step
     *
     * Ends up being something like fibonacci sequence
     *
     * Things I learned:
     * Event through the climbStairsV1 is right, it still doesn't get
     * accepted cause it takes too long. Max n size was 45.
     *
     * So you either have to use memoization or use a DP or Iterative approach
     *
     * Properly name your variables so you don't confuse your self
     *
     *
     * Pattern:
     * If you got some sort of permutations vibes its most likely
     * a DP / Recursive problem
     * **/

    public static void main(String[] args){
        climbStairsV2(4);
    }

    // this is right but it actually fails
    // if you want to do this way your gonna need to use memoization
    public int climbStairsV1(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairsV1(n - 1) + climbStairsV1(n -2);
    }

    // iterative approach
    public static int climbStairsV2(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int One_Step_before = 2;
        int Two_Step_before = 1;
        int final_steps = 0;
        // has to start at 2 instead of 3 since
        // you haven't computed the 3rd value
        // the i only increases after the first iteration
        // that is why we only need a "<" rather then a "="
        for(int i = 2; i< n; i++){
            final_steps = One_Step_before + Two_Step_before;
            // have to reset - always looking for the last two
            Two_Step_before = One_Step_before;
            One_Step_before = final_steps;
        }
        return final_steps;
    }

    // can also use an array to do the same thing as the three
    // variables you used above
    public static int climbStairsV3(int n) {

        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        // if you just put n it's going to
        // make one minus n
        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i<= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
