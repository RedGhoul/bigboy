package com.JavaAlgos.Colt;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sort(new int[] {19,44,38,5,47,15})));
    }

    public static int[] sort(int[] input){
        if(input.length == 0) return input;


        for(int i = 0; i < input.length; i++){
            int curMinIndex = i;
            for(int j = i+1; j < input.length; j++){
                if(input[j] < input[curMinIndex]){
                    curMinIndex = j;
                }
            }
            if(curMinIndex != i){
                swap(curMinIndex,i,input);
            }
        }
        return input;
    }

    public static void swap (int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
