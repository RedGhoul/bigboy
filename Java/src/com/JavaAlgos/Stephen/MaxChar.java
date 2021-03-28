package com.JavaAlgos.Stephen;

import java.util.HashMap;

public class MaxChar {
    public static void main(String[] args){
        System.out.println(FindMaxChar("abccccccccccccccccccccccccccccd"));
        System.out.println(FindMaxChar("apple 123111111111111"));
    }

    // what would be the desired result if two strings appeared the
    // same number of times ?
    public static String FindMaxChar(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
        HashMap<String,Integer> bag = new HashMap<String, Integer>();
        
        for(int i =0; i < input.length(); i++){
            String curString = String.valueOf(input.charAt(i));
            if(bag.containsKey(curString)){
                bag.put(curString, bag.get(curString) + 1);
            } else {
                bag.put(curString,1);
            }
        }
        int max = Integer.MIN_VALUE;
        String maxString = "";
        for (String key: bag.keySet()) {
            int curMax = bag.get(key);
            if(curMax > max){
                max = curMax;
                maxString = key;
            }
        }

        return maxString;
    }
}
