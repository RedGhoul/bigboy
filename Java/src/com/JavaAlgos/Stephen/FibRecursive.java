package com.JavaAlgos.Stephen;

public class FibRecursive {
    public static void main(String[] args){
        System.out.println(GetFibSeries(78));
    }

    public static int GetFibSeries(int input){
        if(input == 0 || input == 1){
            return input;
        }
        return GetFibSeries(input-2) + GetFibSeries(input-1);
    }
}
