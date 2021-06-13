package com.JavaAlgos.Colt;

import java.util.HashMap;
import java.util.Map;

public class isSameArraySquare {
    /*
    * Write a function called same, which accepts two arrays.
    * The function should return true if every value in the array
    * has it's corresponding value squared in the second array.
    * The frequency fo values must be the same
    *
    * Frequency Counter Problem
    * */
    public static void main(String[] args){
        System.out.println(same(new int[]{1,2,3}, new int[]{4,1,9}));
        System.out.println(same(new int[]{1,2,3}, new int[]{1,9}));
        System.out.println(same(new int[]{1,2,1}, new int[]{4,4,1}));
        System.out.println(same(new int[]{1,2,3,2,2,3,2}, new int[]{4,9,1,4,4,4,9}));
    }
    // assuming only ints
    // also assuming there can be doubles in the first array and not the second <- is what I thought
    // doubles can exist as long as they exist in both
    public static boolean same(int[] array1, int[] array2){
        if(array1.length != array2.length) return false;
        HashMap<Integer, Integer> array1Map = new HashMap<>();
        for(int i = 0; i < array1.length; i++){
            int currentInt = array1[i];
            if(array1Map.containsKey(currentInt)){
                array1Map.put(currentInt, array1Map.get(currentInt)+1);// counts how many times its been seen
            }else{
                array1Map.put(currentInt, 0);
            }
        }

        HashMap<Integer, Integer> array2Map = new HashMap<>();
        for(int i = 0; i < array2.length; i++){
            int currentInt = array2[i];
            if(array2Map.containsKey(currentInt)){
                array2Map.put(currentInt,
                        array2Map.get(currentInt)+1); // counts how many times its been seen
            }else{
                array2Map.put(currentInt, 0);
            }
        }

        for(Map.Entry<Integer, Integer> entry : array1Map.entrySet()){

            if(!array2Map.containsKey(entry.getKey()*entry.getKey())){
                return false;
            }
            // checks to see if the counts match
            if(array2Map.get(entry.getKey()*entry.getKey()) != array1Map.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }


}
