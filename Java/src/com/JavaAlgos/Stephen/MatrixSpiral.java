package com.JavaAlgos.Stephen;
import java.util.*;

public class MatrixSpiral {
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(createSpiralMatrix(4)));
    }

    public static int[][] createSpiralMatrix(int size){
        int[][] spiralM = new int[size][size];

        int maxIntValue = size * size;
        int colStart = 0;
        int colEnd = size-1;
        int rowStart = 0;
        int rowEnd = size-1;
        int currentVal = 1;

        while(currentVal <= maxIntValue){
            for(int i = colStart; i <= colEnd; i++){
                spiralM[rowStart][i] = currentVal;
                currentVal++;
            }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++){
                spiralM[i][colEnd] = currentVal;
                currentVal++;
            }
            colEnd--;
            for(int i = colEnd; i >= colStart; i--){
                spiralM[rowEnd][i] = currentVal;
                currentVal++;
            }
            rowEnd--;
            for(int i = rowEnd; i >= rowStart; i--){
                spiralM[i][colStart] = currentVal;
                currentVal++;
            }
            colStart++;

        }

        return spiralM;
    }
}
