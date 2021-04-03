package com.JavaAlgos.Stephen;

public class FibIterative {
    public static void main(String[] args){
        System.out.println(GetFibSeries(4));
    }

    public static int GetFibSeries(int input){
        if(input == 0 || input == 1){
            return input;
        }

        int p1 = 0;
        int p2 = 1;
        int answer = 0;
        // cause we already got the first
        // two iterations out of the way
        input = input-2;
        for(int i = 0; i <= input; i++){
            answer = p1 + p2;
            p1 = p2;
            p2 = answer;
        }
        return p2;
    }
}
