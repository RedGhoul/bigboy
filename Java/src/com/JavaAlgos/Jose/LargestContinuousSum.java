package com.JavaAlgos.Jose;

public class LargestContinuousSum {
    /**
     * Given an array of integers (pos & neg) find the largest continuous sum
     *
     * Can I sort the array ? I am guessing I can't ? Order needs to be preserved
     *
     * If the order didn't matter I could just sort the array. Then sum from the
     * smallest positive number to the very end to get the largest sum.
     *
     *
     * go through the array and do the following:
     *
     * Is the current sum greater than zero ? If it is then continue forward,
     * if it isn't discard the last thing you added. And at the end figure out
     * how big your list was.
     *
     * The key point here is that when the current sum becomes negative
     * all future sums will become more negative, so we reset it to zero.
     *
     * At the same time we are recording what the greatest MaxSum Value is.
     * */
    public static void main(String[] args){
        System.out.println(get(new int[]{1,2,-1,3,4,10,10,-10,-1}));
        System.out.println(get(new int[]{-1,-2,-30,-2,-6,-1}));
        System.out.println(get(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
    public static int get(int[] input){
        if(input.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int startP = 0;
        int endP = 0;
        for(int i =0; i < input.length; i++){
            currentSum = currentSum + input[i];

            if(currentSum > maxSum){
                maxSum = currentSum;
                endP = i;
            }

            if(currentSum < 0){
                currentSum = 0;
                startP = i+1;
            }

        }
        //return Math.abs(endP-startP + 1) ;
        return maxSum;
    }
}
