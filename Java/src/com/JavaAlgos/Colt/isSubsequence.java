package com.JavaAlgos.Colt;

public class isSubsequence {
    public static void main(String[] args){
        System.out.println(is("hello","hello world"));
        System.out.println(is("sing","sting"));
        System.out.println(is("abc","abracadabra"));
        System.out.println(is("abc","acb"));
    }
    /*
    * Function should check whether the characters in the first string
    * appear somewhere in the second string, "With out them changing order"
    * */
    // not taking into account the whole punctuation issue
    // could have do this recursively
    // TIME O(n) & SPACE O(1)
    public static boolean is(String input1, String input2){
        if(input1 == null || input2 == null ||
                input1.length() > input2.length()) return false;

        int input1P = 0;
        int input2P = 0;

        while(input2P < input2.length()){

            char input1Char = input1.charAt(input1P);
            char input2Char = input2.charAt(input2P);
            if(input1Char == input2Char){
                if(input1P == input1.length() -1) return true;
                input1P++;
            }
            input2P++;
        }
        return false;
    }
}
