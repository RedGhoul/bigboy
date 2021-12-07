package com.JavaAlgos.AlgoMonster;

public class SquareRoot {
    /**
     * Given a non-negative integer x, compute and return the square root of x.
     * <p>
     * Since the return type is an integer, the decimal digits are truncated,
     * and only the integer part of the result is returned.
     * <p>
     * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
     * Example 1:
     * <p>
     * Input: x = 4
     * Output: 2
     * Example 2:
     * <p>
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= x <= 231 - 1
     * <p>
     * What your really trying to do here is simply solve the following problem:
     * <p>
     * num * num <= x find num
     * you can actually simplify this further by just doing the following
     * num < x/num
     * <p>
     * Now "num" can be "ANY" number so how do you solve it ??? if you had to search litrally ever single
     * number 0 to MAX_VALUE of Integer ?
     * <p>
     * Well there is a thing called "binary search" and you apply it here
     **/
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        int low = 1;
        int high = x; // cause what ever is the square root of 8 is going to be less than 8
        int finalValue = 0;
        while (low <= high) {
            int value = low + ((high - low) / 2);
            int newTarget = x / value;
            if (value <= newTarget) {
                finalValue = value;
                low = value + 1;
            } else {
                high = value - 1;
            }
        }
        return finalValue;
    }
}
