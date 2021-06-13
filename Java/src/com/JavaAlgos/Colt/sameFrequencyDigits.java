package com.JavaAlgos.Colt;

import java.util.HashMap;
import java.util.Map;

public class sameFrequencyDigits {
    /*
    * Given two positive integers, find out if the two numbers have the same frequency of digits.
    * */

    public static void main(String[] args){
        System.out.println(sameFrequency(182,281));
        System.out.println(sameFrequency(34,14));
        System.out.println(sameFrequency(3589578,5879385));
        System.out.println(sameFrequency(22,222));
    }

    public static boolean sameFrequency(int digit1, int digit2){
        String digits1 = String.valueOf(digit1);
        String digits2 = String.valueOf(digit2);
        if(digits1.length() != digits2.length()) return false;

        HashMap<String,Integer> hashMap1 = createHashMap(digits1);
        HashMap<String,Integer> hashMap2 = createHashMap(digits2);

        for(Map.Entry<String,Integer> entry : hashMap1.entrySet()){
            String currentKey = entry.getKey();
            if(!hashMap2.containsKey(currentKey) || hashMap2.get(currentKey) != entry.getValue()){
                return false;
            }
        }
        return true;
    }


    public static HashMap<String,Integer> createHashMap(String digit){
        HashMap<String,Integer> hashMapV = new HashMap<>();
        for(int i =0; i < digit.length(); i++){
            String curValue = String.valueOf(digit.charAt(i));
            if(hashMapV.containsKey(curValue)){
                hashMapV.put(curValue,hashMapV.get(curValue)+1);
            }else{
                hashMapV.put(curValue,1);
            }
        }
        return hashMapV;
    }
}
