package com.JavaAlgos.Colt;

import java.util.Arrays;

public class ZeroSum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(findZeroSumNaive(new int[]{-3,-2,-1,0,1,2,3})));
        System.out.println(Arrays.toString(findZeroSum3(new int[]{-3,-2,-1,1})));
        System.out.println(Arrays.toString(findZeroSum(new int[]{-233,-2,-1,0,1})));
    }

    // you want to use a little bit of this and that method
    // when ever they tell you its sorted they are giving you a big hint
    //
    public static int[] findZeroSum(int[] arrayIn) {
        if (arrayIn.length == 0) return new int[1];

        int p1 = 0;
        int p2 = arrayIn.length-1;
        while(p1 < p2){
            int sum = arrayIn[p1] + arrayIn[p2];
            if(sum == 0){
                return new int[]{arrayIn[p1],arrayIn[p2]};
            }else if (sum < 0){
                p1++; // way too negative mean move left p to the right
                // since the array is sorted and everything on the left
                // is smallest stuff. So we want less negative
            }else{
                p2--; // way too positive means move the right p to the left
                // since everything on the right is really big. So we want less big
            }
        }
        return new int[1];
    }



    public static int[] findZeroSum3(int[] arrayIn){
        if(arrayIn.length == 0) return new int[1];
        if(arrayIn.length == 2){
            if(arrayIn[1]+arrayIn[0] == 0){
                return arrayIn;
            }
            return new int[1];
        }
        int currentNum1 = 0;
        int currentNum2 = 1;
        while(currentNum1 <= arrayIn.length){
            if(currentNum2 >= arrayIn.length){
                currentNum1++;
                currentNum2 = currentNum1 + 1;
            }
            if(arrayIn[currentNum1]+arrayIn[currentNum2] != 0){
                currentNum2++;
            }else{
                return new int[]{arrayIn[currentNum1],arrayIn[currentNum2]};
            }
        }
        return new int[1];
    }
    public static int[] findZeroSumNaive(int[] arrayIn){
        if(arrayIn.length == 0) return new int[1];
        int currentNum1 = 0;
        int currentNum2 = 0;
        for(int p1 = 0; p1 < arrayIn.length; p1++){
            currentNum1 = arrayIn[p1];
            for(int p2 = 0; p2 < arrayIn.length; p2++){
                if(p2 != p1){
                    currentNum2 = arrayIn[p2];
                    if(currentNum1+currentNum2 == 0){
                        return new int[]{currentNum1,currentNum2};
                    }
                }

            }
        }
        return new int[1];
    }
}
