package com.JavaAlgos.Jose;
import java.util.*;

public class StringCompression {
    /**
     * I am thinking I can just collect common letters together using a hashmap.
     * Then just go through the input and look into the hashmap
     * to make the new compressed array. Since the resulting string still needs to be in the
     * order the original characters came in.
     *
     * Or you could just do a sort of "for" loop. Count the amount of times you have seen X
     * value contiguously. And then when it switches to a new X value, make a new section
     * for that compressed value. This is assuming that the letters will always come side by side.
     * */

    public static void main(String[] args){
        System.out.println(compress("AAAABBBBCCCCCDDEEEE"));
    }

    public static String compress(String input){
        if(input == null || input.length() == 0) return null;
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        String[] inputArray = input.split("");
        for(int i =0; i < inputArray.length; i++){
            String curString = inputArray[i];
            if(result.containsKey(curString)){
                result.put(curString,result.get(curString)+1);
            }else{
                result.put(curString,1);
            }
        }
        String finalResult = "";
        for(int i =0; i < inputArray.length; i++){
            String curValue = inputArray[i];
            if(result.containsKey(curValue)){
                finalResult = finalResult + curValue + result.get(curValue);
                result.remove(curValue);
            }

        }
        return finalResult;
    }
}
