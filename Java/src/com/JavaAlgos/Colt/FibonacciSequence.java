package com.JavaAlgos.Colt;

public class FibonacciSequence {

    public static void main(String[] args){
        System.out.println(interative(10));
        System.out.println(recursive(10));
    }

    public static int interative(int n){
        int curN = 0;
        int nextN = 1;
        for(int i = 0; i < n; i++){
            int tempNextN = nextN;
            nextN = curN + nextN;
            curN = tempNextN;
        }
        return curN;
    }

    public static int recursive(int n){
        if(n <= 1){
            return n;
        }
        return recursive(n-2) + recursive(n-1);
    }
}
