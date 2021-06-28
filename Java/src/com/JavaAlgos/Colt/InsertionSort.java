package com.JavaAlgos.Colt;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sort(new int[]{2,1,9,76,4})));
    }

    public static int[] sort(int[] input){
        if(input.length == 0) return input;
        if(input.length == 2){
            if(input[0] > input[1]){
                int temp = input[0];
                input[0] = input[1];
                input[1] = temp;
            }
            return input;
        }
        //1,2,9,76,4
        for(int i = 1; i < input.length; i++){
            int curValue = input[i];
            int value = -1; // you are putting this here so that the initial
            // at position 1 case gets negated
            for(int j = i - 1; j >= 0; j--){
                if(input[j] > curValue){
                    input[j+1] = input[j];
                }else{
                    value = j;
                    break;
                }

            }
            input[value+1] = curValue;
        }
        return input;
    }
}
