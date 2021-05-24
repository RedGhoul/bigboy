package com.JavaAlgos.Colt;

public class ReverseString {
    public static void main(String[] args){
        System.out.println(reverse2("BIGBOB"));
        System.out.println(reverse1("BIGBOB"));
    }

    /*
    * Ways to do this
    *
    * Double pointer
    * Build a new array
    * */
    public static String reverse2(String input){
        if(input.isEmpty()) return null;
        char[] arrayIn = input.toCharArray();
        int p1 = 0;
        int p2 = arrayIn.length-1;

        while(p1< p2){
            char temp = arrayIn[p1];

            arrayIn[p1] = arrayIn[p2];

            arrayIn[p2] = temp;
            p1++;
            p2--;
        }
        return String.valueOf(arrayIn);
    }

    public static String reverse1(String input){
        if(input.isEmpty()) return null;
        char[] arrayIn = input.toCharArray();

        char[] newArray = new char[arrayIn.length];
        int count = 0;
        for(int i = arrayIn.length-1; i >= 0; i--){
            newArray[count] = arrayIn[i];
            count++;
        }
        return String.valueOf(newArray);
    }
}
