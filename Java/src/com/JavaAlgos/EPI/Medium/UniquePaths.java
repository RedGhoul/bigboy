package com.JavaAlgos.EPI.Medium;

import java.util.Arrays;

public class UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach
     * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: m = 3, n = 7
     * Output: 28
     * Example 2:
     * <p>
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     * Example 3:
     * <p>
     * Input: m = 7, n = 3
     * Output: 28
     * Example 4:
     * <p>
     * Input: m = 3, n = 3
     * Output: 6
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= m, n <= 100
     * It's guaranteed that the answer will be less than or equal to 2 * 109.
     * <p>
     * Initial thoughts:
     * <p>
     * Came in thinking this was going to be some sort of recursive problem
     * <p>
     * And in a sense it was, but it is really a dynamic problem
     * <p>
     * Reals:
     * <p>
     * Regardless of which way you solve this, you will only figure it out once you have draw out the
     * picture of the tabulation.
     * <p>
     * The first way was through recursion, where you would recursively compute the
     * left & right values that made the middle, and your base case was that at 0 , 0 you would only have one way to
     * get to the end.
     * And you would be going through a M X N matrix, where you would be computing stuff from top left corner to
     * bottom right corner
     * <p>
     * The second way was to compute by 2 rows, and do it bottom to top, cause you know that the next value in the
     * array above was simply:
     * bottom array at index X + top array at index X -1
     * value   AX2  AX1
     * BX3    BX2  BX1
     * <p>
     * and you know that value would be just equal to AX2 + BX3
     * <p>
     * The Time Complexity is m * n since you go through every part of the matrix & we do O(1) work
     * Space complexity for first one is O(m*n)
     * Space complexity for 2nd one is O(n) its 2n but then we remove the 2 cause its not significant
     **/

    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1, new int[m][n]);
    }

    public int uniquePathsHelper(int m, int n, int[][] input) {
        if (m == 0 && n == 0) return 1;
        if (input[m][n] == 0) {
            int top = n == 0 ? 0 : uniquePathsHelper(m, n - 1, input);
            int right = m == 0 ? 0 : uniquePathsHelper(m - 1, n, input);
            input[m][n] = top + right;
        }
        return input[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 7));
    }

    public static int uniquePaths2(int m, int n) {
        int[] baseRow = new int[n];
        Arrays.fill(baseRow, 1);

        for (int i = 0; i < m - 1; i++) {
            int[] baseRowAns = new int[n];
            Arrays.fill(baseRowAns, 1);

            for (int j = n - 1; j >= 0; j--) {
                if (j - 1 >= 0) {
                    baseRowAns[j - 1] = baseRowAns[j] + baseRow[j - 1];
                }

            }
            baseRow = baseRowAns;
        }
        return baseRow[0];
    }
}
