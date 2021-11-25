package com.JavaAlgos.EPI.Medium;

import java.util.HashSet;

public class ValidSudoku {
    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     * <p>
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     **/

    public static void main(String[] args) {
        String[][] table = {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
    }

    public boolean isValidSudoku(char[][] board) {
        // set inital hashset
        HashSet<Character> bag = new HashSet<>();
        boolean areRowsValid = false;
        // Go through the rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char curVal = board[i][j];
                if (curVal == '.') continue;
                if (bag.contains(curVal)) return false;
                bag.add(curVal);
            }
            bag.clear();
        }
        areRowsValid = true;


        boolean areColsValid = false;
        // Got through the col
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char curVal = board[j][i];
                if (curVal == '.') continue;
                if (bag.contains(curVal)) return false;
                bag.add(curVal);
            }
            bag.clear();
        }
        areColsValid = true;

        boolean areSqauresValid = false;
        // got through the little sqaures
        HashSet<Character> bag1 = new HashSet<>();
        HashSet<Character> bag2 = new HashSet<>();
        HashSet<Character> bag3 = new HashSet<>();
        for (int i = 0; i < board.length; i++) {

            int start = 0;
            int end = 2;
            for (int j = start; j <= end; j++) {
                char curVal = board[i][j];
                if (curVal == '.') continue;
                if (bag1.contains(curVal)) return false;
                bag1.add(curVal);
            }

            start = start + 3;
            end = end + 3;
            for (int j = start; j <= end; j++) {
                char curVal = board[i][j];
                if (curVal == '.') continue;
                if (bag2.contains(curVal)) return false;
                bag2.add(curVal);
            }

            start = start + 3;
            end = end + 3;
            for (int j = start; j <= end; j++) {
                char curVal = board[i][j];
                if (curVal == '.') continue;
                if (bag3.contains(curVal)) return false;
                bag3.add(curVal);
            }

            if (i + 1 % 3 == 0) {
                bag1.clear();
                bag2.clear();
                bag3.clear();
            }
        }


        return areRowsValid && areColsValid && areSqauresValid;
    }
}
