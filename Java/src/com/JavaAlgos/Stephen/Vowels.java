package com.JavaAlgos.Stephen;

public class Vowels {
    public static void main(String[] args){
        System.out.println(findVowels("Hi There!"));
        System.out.println(findVowels("Why do you ask?"));
        System.out.println(findVowels("Why?"));
    }

    public static int findVowels(String input){
        char[] inputArr = input.toCharArray();
        int vowelCount = 0;
        for(int i = 0; i < inputArr.length; i++){
            char curChar = inputArr[i];
            if(curChar == 'i' || curChar == 'o' || curChar == 'u'
                    || curChar == 'a' || curChar == 'e'){
                vowelCount++;
            }
        }

        return vowelCount;
    }
}
