package com.JavaAlgos.Stephen;

public class FizzBuzz {
    public static void main(String[] args){
        FizzBuzz(5);
    }

    public static void FizzBuzz(int n){
        for(int i =1; i <= n; i++){
            boolean multi3 = i % 3 == 0;
            boolean multi5 = i % 5 == 0;

            if (multi3 && multi5){
                System.out.println("fizzbuzz");
            } else if (multi3) {
                System.out.println("fizz");
            } else if (multi5) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
