package com.JavaAlgos.Stephen;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args){
        System.out.println(Arrays.toString(sort(new int[]{1,2,33,44,0,22,99,5,6,4})));
    }

    /*
    * The prove me wrong algorithm
    * */
    public static int[] sort(int[] arrayIn){
        if(arrayIn.length == 0) return new int[0];
        for(int i = 0; i < arrayIn.length-1; i++){
            int locationOfSmallest = i;
            // here in this inner for loop, what you are really trying to do
            // is find the smallest thing
            for(int j=i+1; j < arrayIn.length; j++){
                // arrayIn[minlocal] <- the reason you have to do this is that now you have
                // to compare to the CURRENT lowest thing in the array
                // NOT what ever you had before which is what you were doing with arrayIn[i]
                // you are looking for the smallest thing period !!!
                int valueOfSmallest = arrayIn[locationOfSmallest];
                if(arrayIn[j] < valueOfSmallest){// is the current value smaller ?
                    locationOfSmallest = j;
                }
            }
            if(i != locationOfSmallest){
                int lesser = arrayIn[locationOfSmallest];
                arrayIn[locationOfSmallest] = arrayIn[i];
                arrayIn[i] = lesser;
            }
        }
        return arrayIn;
    }



}
