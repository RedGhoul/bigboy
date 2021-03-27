package com.JavaAlgos.Stephen;

public class ReverseString {
    public static void main(String[] args){
        System.out.println(reverseString1("avanee"));
        System.out.println(reverseString1("ava"));
        System.out.println(reverseString1("ba"));
    }

    // two pointer swap
    public static String reverseString1(String input){
        if(input == null || input.length() == 0){
            return input;
        }

        char[] stringArr = input.toCharArray();

        int p1 = 0;
        int p2 = input.length()-1;

        while(p2 > p1){
            char temp = stringArr[p1];

            stringArr[p1] = stringArr[p2];

            stringArr[p2] = temp;

            p2--;
            p1++;
        }

        return String.valueOf(stringArr);

    }
}
