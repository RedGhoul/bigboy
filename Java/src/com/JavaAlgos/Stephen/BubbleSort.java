package com.JavaAlgos.Stephen;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sort(new int[]{1,2,33,44,0,22,99,5,6,4})));
    }
    /*
    * swap pairs (elements right next to each other) X times
    * where X is the number of elements in the array
    * */
    public static int[] sort(int[] arrayIn){
        if(arrayIn.length == 0) return new int[0];
        for(int i = 0; i < arrayIn.length; i++){

            for(int j = 0; j < arrayIn.length; j++){
                if(j+1 == arrayIn.length) break;
                int currentInt = arrayIn[j];
                int nextInt = arrayIn[j+1];
                if(currentInt > nextInt){
                    swap(j,j+1,arrayIn);
                }
            }
        }
        return arrayIn;
    }

    public static void swap(int p1, int p2, int[] array){
        int p1v = array[p1];
        int p2v = array[p2];

        array[p1] = p2v;
        array[p2] = p1v;
    }
}
