package com.JavaAlgos.Stephen;

import java.util.Locale;

public class SentenceCap {
    public static void main(String[] args){
        System.out.println(CapSen("a short sentence"));
        System.out.println(CapSen("a lazy fox"));
        System.out.println(CapSen("Look its working !"));
    }

    public static String CapSen(String input){
        if(input == null || input.length() == 0){
            return input;
        }

        String[] inputArr = input.split(" ");
        for(int i = 0; i < inputArr.length; i++){
            String currentString = inputArr[i];

            // if you don't put an end point it goes all the way to the end
            currentString = currentString.substring(0,1).toUpperCase() + currentString.substring(1);

            inputArr[i] = currentString;
        }

        return String.join(" ",inputArr);
    }
}
