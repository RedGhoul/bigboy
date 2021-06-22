package com.JavaAlgos.Colt;

public class RecursivePowers {
    public static void main(String[] args){
        System.out.println(power(2,4));
    }

    public static int power(int base, int expo){
        if(expo == 0 || (base == 0 && expo == 0)){
            return 1;
        }
        if(base == 0 && expo == 1) return 0;
        return base * power(base,expo-1);
    }
}
