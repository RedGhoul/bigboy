package com.JavaAlgos.Stephen;

public class Palindromes {
    /*
    * A palindrome is a word, number, phrase, or other sequence of characters which reads the
    * same backward as forward, such as madam or racecar.
    * */
    public static void main(String[] args){
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("avanee"));
    }

    // two pointer method
    // guessing that "aa" is a valid palindrome
    public static boolean isPalindrome(String input){
        if(input == null || input.length() == 0){
            return false;
        }

        char[] inputArr = input.toCharArray();

        int p1 = 0;
        int p2 = input.length() - 1;

        while(p2 > p1){
            if(inputArr[p2] != inputArr[p1]){
                return false;
            }
            p2--;
            p1++;
        }

        return true;
    }
}
