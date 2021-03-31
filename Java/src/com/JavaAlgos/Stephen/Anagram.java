package com.JavaAlgos.Stephen;

import java.util.*;

public class Anagram {
    /*
    * An anagram is a word or phrase formed by rearranging the letters of a
    * different word or phrase, typically using all the original letters exactly once.
    * */
    public static void main(String[] args){
        System.out.println(isAnagram("rail safety", "fairy tales"));
        System.out.println(isAnagram("RAIL! safety!", "fairy tales"));
        System.out.println(isAnagram("Hi", "Bye"));
    }

    // casing matters

    public static boolean isAnagram(String input1, String input2){
        // could add input2.length() != input2.length() however would not account for punctuation
        if(input2 == null || input1 == null || input1.length() == 0 ||
                input2.length() == 0){
            return false;
        }
        input1 = input1.toLowerCase().replaceAll(" ", "");
        input2 = input2.toLowerCase().replaceAll(" ", "");

        char[] inputCharArr = input1.toCharArray();

        HashMap<Character,Integer> counterBag = new HashMap<Character,Integer>();

        for(int i = 0; i < inputCharArr.length; i++){
            Character currentChar = inputCharArr[i];
            // add this check to make sure to account for punctuation
            if(Character.isLetterOrDigit(currentChar)){
                if(counterBag.containsKey(currentChar)){
                    counterBag.put(currentChar, counterBag.get(currentChar) + 1);
                }else{
                    counterBag.put(currentChar, 1);
                }
            }

        }

        for(int i = 0; i <input2.length(); i++){
            Character currentChar = input2.charAt(i);
            // add this check to make sure to account for punctuation
            if(Character.isLetterOrDigit(currentChar)){
                if(!counterBag.containsKey(input2.charAt(i))){
                    return false;
                }
            }

        }

        return true;
    }
}
