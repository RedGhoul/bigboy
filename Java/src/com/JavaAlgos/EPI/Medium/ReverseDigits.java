package com.JavaAlgos.EPI.Medium;

public class ReverseDigits {
    // this is from the book, but I am too lazy to copy the q from the book so I just copied it from
    // leetcode
    /**
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
     * the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     *
     * Example 1:
     *
     * Input: x = 123
     * Output: 321
     * Example 2:
     *
     * Input: x = -123
     * Output: -321
     * Example 3:
     *
     * Input: x = 120
     * Output: 21
     * Example 4:
     *
     * Input: x = 0
     * Output: 0
     *
     *
     * Constraints:
     *
     * -231 <= x <= 231 - 1
     *
     *
     * What I am thinking:
     *
     * Brute force straight forward way of doing it would be to:
     * 0) make note of the sign of the int
     * 1) convert int to string
     * 2) reverse string
     * 3) convert new string to int and add back the sign
     *
     * There wasn't any bit manipulation trick to this question
     * Rather it was just plain old math and the mod operator
     *
     * what you have to know:
     * when you multiply something by 10 you are adding a zero
     * When you are taking the mod of something by 10 you are taking the right number
     * What you are doing is building up the reverse of the number through these operations
     *
     * 1132 % 10 = 2
     * its the ones so it doen't need to be mutliupled by anything but its the first number
     * So all you're doing in the very first pass is taking the very last digit and moving out in front
     * Then removing that digit by dividing by 10
     * Then going though the same process again, except this time you have a value for result
     * so you are padding it by a zero which gives remove for 3
     *
     * So the process looks like this
     *
     * 1132
     *
     * result = 0 * 10 + (1132 % 10 = 2) = 2
     * x = x / 10 = 1132 / 10 = 113 // removed the last digit
     * result = 2 * 10 + (113 % 10 = 3)
     * result = 20 (adding the padding) + 3 = 23
     * x = x/10 = 113 / 10 = 11
     *
     * and it works out like that
     * */

    /**
     * solved the problem but does not account for the overflow of the int.
     * an int in java is only 32 bits
     **/
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = result * 10 + (x % 10);
            // making sure we didn't just overflow, by making sure if we und to the operation
            // we get back to the same thing we had before
            // first we remove the last digit, and then we divide by 10
            if ((temp - (x % 10)) / 10 != result) return 0;

            result = temp;
            x = x / 10;
        }
        return result;
    }
}
