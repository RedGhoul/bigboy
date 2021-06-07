package com.JavaAlgos.Colt;
import java.util.*;
public class Anagrams {
    public static void main(String[] args){
        System.out.println(isAnagram("",""));
        System.out.println(isAnagram("aaz","zza"));
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
        System.out.println(isAnagram("awesome","awesom"));
        System.out.println(isAnagram("qwerty","qeywrt"));
        System.out.println(isAnagram("texttwisttime","timetwisttext"));
    }

    /*
    * An anagram is a word, phrase, or name formed by rearranging
    * the letters of another, such as cinema, formed from iceman
    * */

    public static boolean isAnagram(String input1, String input2){
        if(input1 == null || input2 == null || input2.length() != input1.length()){
            return false;
        }

        HashMap<String, Integer> newHashMap1 = generateHashMap(input1);
        HashMap<String, Integer> newHashMap2 = generateHashMap(input2);

        for(Map.Entry<String,Integer> entry: newHashMap1.entrySet()){
            if(!newHashMap2.containsKey(entry.getKey())){
                return false;
            }
            if(newHashMap2.get(entry.getKey()) != entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static HashMap<String,Integer> generateHashMap(String input1){
        HashMap<String,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < input1.length(); i++){
            String currentStr = String.valueOf(input1.charAt(i));
            if(hashmap.containsKey(currentStr)){
                hashmap.put(currentStr, hashmap.get(currentStr)+1);
            }else{
                hashmap.put(currentStr, 0);
            }
        }
        return hashmap;
    }


}
