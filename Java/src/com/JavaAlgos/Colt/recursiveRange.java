package com.JavaAlgos.Colt;

public class recursiveRange {

    public static void main(String[] args){
        System.out.println(rr(6));
        System.out.println(rr(10));
    }

    public static int rr(int input){
        if(input == 0){
            return 0;
        }
        return input + rr(input-1);
    }
}
