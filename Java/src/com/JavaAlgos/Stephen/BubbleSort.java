package com.JavaAlgos.Stephen;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sort(new int[]{1,2,33,44,0,22,99,5,6,4})));
    }
    /*
    * Find the largest thing in the array and move it over to the right
    * Over the course of a bunch of little swaps
    * Is what you do every integration of the outer for - loop
    *
    *
    * Every iteration of the outer for loop, results in the biggest value
    * being moved all the way to the right.
    *
    * In doing so we don't have to
    * go through the entire length of the array every time. Since we are
    * forming a sorted section on the right
    * */
    public static int[] sort(int[] arrayIn){
        if(arrayIn.length == 0) return new int[0];
        for(int i = 0; i < arrayIn.length; i++){

            for(int j = 0; j < (arrayIn.length-1)-i; j++){
                int currentInt = arrayIn[j];
                int nextInt = arrayIn[j+1];//(arrayIn.length-1)-i <- do this so we only every come
                // to the second last index in the array
                if(currentInt > nextInt){
                    swap(j,j+1,arrayIn);
                }
            }
        }
        return arrayIn;
    }

    public static void swap(int p1, int p2, int[] array){
        int p1v = array[p1];
        array[p1] = array[p2];
        array[p2] = p1v;
    }
}
