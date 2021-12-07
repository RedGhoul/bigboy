package com.JavaAlgos.EPI.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * <p>
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     **/

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return new ArrayList<>();
        List<Integer> finalAnswer = new ArrayList<>();
        // setup vars here
        int minX = 0;
        int maxX = matrix[0].length - 1;
        int minY = 0;
        int maxY = matrix.length - 1;
        int maxArrSize = matrix[0].length * matrix.length;
        // do while loop
        while (minX <= maxX && minY <= maxY) {
            // do left to right
            for (int i = minX; i <= maxX; i++) {
                int curVal = matrix[minY][i];
                if (finalAnswer.size() < maxArrSize) {
                    finalAnswer.add(curVal);
                }

            }
            minY++;
            // top to down
            for (int i = minY; i <= maxY; i++) {
                int curVal = matrix[i][maxX];
                if (finalAnswer.size() < maxArrSize) {
                    finalAnswer.add(curVal);
                }
            }
            maxX--;
            // do right to left
            for (int i = maxX; i >= minX; i--) {
                int curVal = matrix[maxY][i];
                if (finalAnswer.size() < maxArrSize) {
                    finalAnswer.add(curVal);
                }
            }
            maxY--;
            // do bottom to top
            for (int i = maxY; i >= minY; i--) {
                int curVal = matrix[i][minX];
                if (finalAnswer.size() < maxArrSize) {
                    finalAnswer.add(curVal);
                }
            }
            minX++;
        }

        return finalAnswer;
    }
}
