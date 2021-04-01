package com.JavaAlgos.Stephen;

import java.util.Arrays;

public class Pyramids {
    public static void main(String[] args){
        //printPyramid(1);
        printPyramid(2);
        printPyramid(300);
    }

    public static void printPyramid(int levels){
        if(levels == 0) return;

        String[] output = new String[findMaxWidth(levels)];
        Arrays.fill(output," ");
        int midP = (int)Math.ceil((output.length -1)/ 2);
        output[midP] = "#";
         System.out.println(String.join("",output));

        int pL = midP-1;
        int pR = midP+1;
        for(int i =1; i < levels; i++){
            output[pL] = "#";
            output[pR] = "#";
            System.out.println(String.join("",output));
            pL--;
            pR++;
        }

    }

    public static int findMaxWidth(int levels){
        if(levels == 1) return 1;
        int curMax = 1;
        for(int i =1; i < levels; i++){
            curMax = curMax + 2;
        }
        return curMax;
    }
}
