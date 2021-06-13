package com.JavaAlgos.Colt;
import java.util.*;

public class AreThereDuplicates {
    public static void main(String[] args){
        System.out.println(aretherduplicates(new int[]{1,3,24,2,4,23,3,3,4,42222,4}));
        System.out.println(aretherduplicates(new int[]{1,3,24,2,4}));
    }


    public static boolean aretherduplicates(int[] arrays){
        if(arrays.length == 0)return false;
        HashMap<Integer,Integer> hashmapbag = new HashMap<>();

        for(int i =0; i < arrays.length; i++){
            if(hashmapbag.containsKey(arrays[i])){
                return true;
            }else{
                hashmapbag.put(arrays[i],1);
            }
        }
        return false;
    }
}
