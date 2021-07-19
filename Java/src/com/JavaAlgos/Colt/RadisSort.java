package com.JavaAlgos.Colt;

import java.util.ArrayList;
import java.util.List;

public class RadisSort {


    public static void main(String[] args){

    }

    public static List<Integer> sort(List<Integer> input){
        if(input == null) return null;
        int maxDigit = maxDigitCount(input);
        for(int i = 0; i < maxDigit; i++){
            List<List<Integer>> bucketList = new ArrayList<>();
            for(int j = 0; j < input.size(); j++){
                int curNum = input.get(j);
                int bucketName = getDigit(curNum,i);
                bucketList.get(bucketName).add(curNum);
            }
            List<Integer> newInput = new ArrayList<>();
            for(int a = 0; a < bucketList.size(); a++){
                newInput.addAll(bucketList.get(a));
            }
            input = newInput;
        }
        return input;
    }

    public static int getDigit(int num, int index){
        return (int) (Math.floor(num/Math.pow(10,index)) % 10);
    }

    public static int digitCount(int num){
        return (int) (Math.log10(num)+1);
    }

    public static int maxDigitCount(List<Integer> input){
        int max = 0;
        for(int i =0; i < input.size(); i++){
            max = Math.max(max,input.get(i));
        }
        return max;
    }
}
