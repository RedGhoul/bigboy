package com.JavaAlgos.Stephen;

import java.util.HashMap;

public class FibRecursiveMemo {
    public static void main(String[] args){
        System.out.println(GetFibSeries(78, null));
    }

    public static int GetFibSeries(int input, HashMap<Integer, Integer> bag){
        if(bag == null){
            bag = new HashMap<Integer,Integer>();
        }
        if(input == 0 || input == 1){
            return input;
        }
        int value = 0;
        if(bag.containsKey(input)){
            return bag.get(input);
        } else {
            // forgot to put the bag in there
            value = GetFibSeries(input-2, bag) + GetFibSeries(input-1, bag);
            bag.put(input, value);
        }

        return value;
    }
}
