package com.JavaAlgos.Colt;

public class AddNumbers {
    public static void main(String[] args){
        System.out.println(add1(10000));
        System.out.println(add2(10000));
    }

    public static int add1(int n){
        int total = 0;
        for(int i = 1; i <= n; i++){
            total = total + i;
        }
        return total;
    }
    // java follows bedmass
    public static int add2(int n){
        return n*(n+1)/2;
    }

}
