package com.JavaAlgos.Stephen;

import java.util.*;
import java.util.logging.Level;


public class MergeSort {
    /*
    * The keys to this are two functions,
    * where one is calling the other
    *
    * -- Breaker Function
    * Breaks and calls combiner recursively
    *
    * -- Combiner Function
    * Combines two arrays in traditional fashion
    *
    * Breaking down a big array into smaller arrays and singles
    * Then comparing them to find a bigger array
    *
    *
    * */

    public static void main(String[] args){
        ArrayList<Integer> gfg = new ArrayList<Integer>() {
            {
                add(1);
                add(22);
                add(0);
                add(44);
                add(-3);
            }
        };
        System.out.println(Arrays.toString(Sort(gfg).toArray()));
    }

    public static List<Integer> Sort(ArrayList<Integer> input){
        if(input.size() == 1) return input; // this piece is super important it is the base case
        // since if something is only size one then return it
        int half = (int)Math.floor((input.size()-1) / 2);
        // sublist goes one less then the end
        List<Integer> left;
        List<Integer> right;
        left = input.subList(0,half+1);
        right = input.subList(half+1,input.size()); //size always gives us one bigger
        var Left = new ArrayList<Integer>(left);
        return merger(Sort(new ArrayList<Integer>(left)), Sort(new ArrayList<Integer>(right)));
    }

    public static List<Integer> merger(List<Integer> left, List<Integer> right){
        if(left == null || right == null) return new ArrayList<Integer>();
        if(left.size() == 0 || right.size() == 0) return new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<>();
        while(left.size() > 0 && right.size() > 0){
            if(left.get(0) < right.get(0)){
                answer.add(left.remove(0));
            }else{
                answer.add(right.remove(0));
            }
        }
        while(right.size() > 0){
            answer.add(right.remove(0));
        }
        while(left.size() > 0){
            answer.add(left.remove(0));
        }
        return answer;
    }
}
