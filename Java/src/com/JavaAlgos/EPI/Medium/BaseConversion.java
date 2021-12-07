package com.JavaAlgos.EPI.Medium;

public class BaseConversion {
    /**
     * EPI says to write a function that can go from one base to another base
     * <p>
     * Did not find a question like that on leet code, so just doing a based 10 to base 2
     * type problem below.
     * <p>
     * Base 10 to base 2 conversion rather simple, and is a simple pattern
     * All you have to do is  input 22
     * 1) Mod the number to get your right most value   22 mod 2 = 0 ++
     * 2) divide 22 by 2   22 / 2 = 11
     * 3) 11 mod 2 = 1                                               ++
     * 4) 11 / 2 = 5
     * 5) 5 mod 2 = 1                                                ++
     * 6) 5 / 2 = 2
     * 7) 2 mod 2 = 0                                                ++
     * 8) 2 / 2 = 1
     * 9) 1 mod 2 = 1                                                ++
     * 10 1/2
     * the end answer is gonna be 10110
     * <p>
     * The general Idea here is the following:
     * <p>
     * 1) Mod the number by the base you want to convert it to - get your first right value
     * 2) Divide the given number by the base
     * 3) Take that number you got in step 2 and now mod it by the base
     * 4) Do this until your result in step three is zero
     **/

    public static void main(String[] args) {
        System.out.println(baseNeg2(2));
    }

    // I am just do the 1017. Convert to Base -2 down here
    public static String baseNeg2(int n) {
        return baseNeg2Helper(n);
    }

    public String baseNeg2LC(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int r = N % (-2);
            N = N / (-2);
            if (r < 0) {
                r += 2;
                N += 1;
            }
            sb.append(r);
        }
        return sb.reverse().toString();
    }

    public static String baseNeg2Helper(int n) {
        if (n == 0) return "";
        int binVal = n % -2;
        int nextVal = n / -2;
        return baseNeg2Helper(nextVal) + String.valueOf(Math.abs(binVal));
    }
}
