package com.JavaAlgos.Colt;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        System.out.println(merge(new ArrayList<Integer>(){{
            add(8);
            add(3);
            add(5);
            add(4);
            add(7);
            add(6);
            add(1);
            add(2);
        }}));
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> input){
        if(input == null || input.size() == 1) return input;
        int halfWay = (int)Math.floor(input.size() / 2);
        ArrayList<Integer> input1 = new ArrayList<Integer>(input.subList(0,halfWay));
        ArrayList<Integer> input2 = new ArrayList<Integer>(input.subList(halfWay, input.size()));
        return sort(merge(input1),merge(input2));
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> input1, ArrayList<Integer> input2){
        ArrayList<Integer> output = new ArrayList<>();

        // don't need to increment these since you are always taking
        // some form the start of the array list
        int p1 = 0;
        int p2 = 0;

        while(p1 <= input1.size()-1 && p2 <= input2.size()-1){
            int value1 = input1.get(p1);
            int value2 = input2.get(p2);
            if(value1 <= value2){
                output.add(value1);
                input1.remove(p1);
            }else{
                output.add(value2);
                input2.remove(p2);
            }
        }
        p1 = 0;
        while(input1.size() > 0){
            output.add(input1.remove(p1));
        }

        p2 = 0;
        while(input2.size() > 0){
            output.add(input2.remove(p2));
        }

        return output;
    }

}
