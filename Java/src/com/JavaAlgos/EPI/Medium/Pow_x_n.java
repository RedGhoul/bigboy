package com.JavaAlgos.EPI.Medium;

public class Pow_x_n {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * <p>
     * Example 1:
     * <p>
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     * <p>
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     * <p>
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * <p>
     * <p>
     * Constraints:
     * <p>
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     * <p>
     * This was in the Primitives' section of EPI, so you know it is going to involve bit manipulation.
     * <p>
     * Standard thing to do would be to just say:
     * x ^ 3 = x * x * x
     * <p>
     * but that's too easy, and apprantly that 2 ^ N
     * <p>
     * but you can get away with doing less multiples
     * <p>
     * The EPI version used bit manipulation
     * <p>
     * But the following based on a leet code col
     * keep dividing the expo by 2
     * trying to reduce the number of multiples by, dividing subsets of the problem by its self
     * the x always stays the same
     **/

    public double myPow(double x, int n) {
        // when you have number to the exponent of a negative number it is just (1 / number) ^ n
        if (n < 0) {
            x = 1 / x;
        }
        return myPowHelper(x, n);
    }

    public static double myPowHelper(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double res = myPowHelper(x, Math.abs(n / 2));
        res = res * res;
        if (n % 2 != 0) {
            return x * res;
        }
        return res;
    }
}
