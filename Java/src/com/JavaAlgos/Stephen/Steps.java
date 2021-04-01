package com.JavaAlgos.Stephen;
import java.util.*;

public class Steps {
    public static void main(String[] args){
        printStep(2);
        printStep(3);
        printStep(4);
    }

    public static void printStep(int numberOfSteps){
        if(numberOfSteps == 0) return;
        String[] output = new String[numberOfSteps];
        Arrays.fill(output," ");
        for(int i = 0; i < output.length; i++){
            output[i] = "#";
            System.out.println(String.join("",output));
        }
    }
}

