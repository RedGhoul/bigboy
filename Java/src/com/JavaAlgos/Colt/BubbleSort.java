package com.JavaAlgos.Colt;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sort(new int[] {10,14,29,30,14,18,37})));
    }

    public static int[] sort(int[] input){
        if(input.length == 0) return input;

        for(int i = input.length-1; i >= 0 ; i--){
            for(int j = 0; j <= i; j++){
                if(j+1 <= input.length-1 && input[j] > input[j+1]){
                    swap(j,j+1,input);
                }

            }
        }
        return input;
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
