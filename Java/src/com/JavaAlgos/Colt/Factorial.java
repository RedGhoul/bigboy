package com.JavaAlgos.Colt;

public class Factorial {
    public static void main(String[] args){
        System.out.println(interactive(10));
        System.out.println(recursive(10));
    }

    public static int interactive(int n){
        int curN = 1;

        for(int i = 1; i <= n; i++){

            curN = curN * i;
        }
        return curN;
    }

    public static int recursive(int n){
        if(n == 1){
            return n;
        }
        return  n * recursive(n-1);
    }
}
