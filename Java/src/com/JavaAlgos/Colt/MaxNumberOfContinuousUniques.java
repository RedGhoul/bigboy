package com.JavaAlgos.Colt;

import java.util.HashMap;

public class MaxNumberOfContinuousUniques {
    public static void main(String[] args){
        System.out.println(findMaxContinuousUniques("hellothere"));
    }
    /*
    * */
    public static int findMaxContinuousUniques(String input){
        if(input == null) return 0;
        if(input.length() <= 1) return input.length();
        HashMap<String,Integer> seen = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < input.length(); i++){
            String curString = String.valueOf(input.charAt(i));
            if(seen.containsKey(curString)){
                if(seen.size() > maxCount){
                    maxCount = seen.size();
                }
                seen = new HashMap<>();

            }
                seen.put(curString,0);

        }
        return maxCount;
    }
}
