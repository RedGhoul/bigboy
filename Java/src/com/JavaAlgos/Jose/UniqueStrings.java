package com.JavaAlgos.Jose;
import java.util.*;
public class UniqueStrings {
    /*
    * determine if a string has all unique characters
     */
    public static void main(String[] args){
        System.out.println(isUnique_hash("hashmapaaaa"));
        System.out.println(isUnique_Set("hashmappppp"));
        System.out.println(isUnique_Set("abv"));
        System.out.println(isUnique_hash("abv"));
        System.out.println(isUnique_hash(""));
        System.out.println(isUnique_Set(""));
        System.out.println(isUnique_Set(null));
    }

    /**
     * Option 1: Could just use a hashmap ?
     *
     * Option 2: I think you could also do this as a straight-up array.
     * Could just end up doing something like a double for loop
     *
     * Option 3: Could just use a SET !!!!!!!!!!!!!!!!!!!!!!
     * All operations are O(1)
     * */
    public static boolean isUnique_hash(String input){
        if(input == null || input.isEmpty()) return false;
        HashMap<String,Integer> curMap = new HashMap<String,Integer>();
        String[] inputArray = input.split("");
        for(int i = 0; i < inputArray.length; i++){
            if(curMap.containsKey(inputArray[i])){
                return false;
            }
            curMap.put(inputArray[i],1);
        }
        return true;
    }

    public static boolean isUnique_Set(String input){
        if(input == null || input.isEmpty()) return false;
        Set<String> newSet = new HashSet<String>();
        String[] inputArray = input.split("");
        for(int i = 0; i < inputArray.length; i++){
            newSet.add(inputArray[i]);
        }
        return newSet.size() == inputArray.length;
    }
}
