package com.JavaAlgos.EPI.Easy;

import java.util.Arrays;

public class PlusOne {
    // you have already done this problem before

    /**
     * 123
     * 1
     * 124
     * 111
     * 9999
     * 1
     * 10000
     * <p>
     * You would use an array list to make your life easier
     * carry if add 1 to the last number > 9
     * current value at this current index would set 0
     * if it isn't
     * current value at this current index = current value + 1;
     * return array
     * <p>
     * Start from right to left
     * For loop start from length-2
     * if(carry){
     * add 1 to the current number + 1;
     * <p>
     * }else{
     * add 1 to the current number
     * }
     * <p>
     * <p>
     * check if that number is > 9
     * then we have carry = true
     * current value at this current index would set 0
     * if it isn't we would
     * <p>
     * current value at this current index = current value + 1;
     * return array
     * <p>
     * if(carry left )
     * add 1 to the front
     * <p>
     * return the final Array
     **/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(PlusOnePEI(new int[]{9})));
        System.out.println(Arrays.toString(PlusOnePEI(new int[]{0})));
        System.out.println(Arrays.toString(PlusOnePEI(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(PlusOnePEI(new int[]{1, 2, 3})));

        System.out.println(Arrays.toString(PlusOnePEI(new int[]{9, 1, 9, 9, 9})));
        System.out.println(Arrays.toString(PlusOnePEI(new int[]{9, 9, 9, 9, 9})));
    }

    public static int[] PlusOnePEI(int[] input) {
        if (input.length == 0) return new int[]{};
        boolean isThereCarry;

        int firstIntVal = input[input.length - 1];
        if (firstIntVal + 1 > 9) {
            isThereCarry = true;
            input[input.length - 1] = 0;
        } else {
            input[input.length - 1] = firstIntVal + 1;
            return input;
        }

        for (int i = input.length - 2; i >= 0; i--) {
            int tempCad = input[i];
            if (isThereCarry) {
                tempCad = tempCad + 1;
            }

            if (tempCad > 9) {
                isThereCarry = true;
                input[i] = 0;
            } else {
                input[i] = tempCad;
                isThereCarry = false;
            }
        }

        if (isThereCarry) {
            // when creating an array it doesn't start from zero,
            // if you as for three it will give you three spaces
            // And input.length starts from 1
            int[] temp = new int[input.length + 1];
            for (int i = input.length - 1; i >= 0; i--) {
                temp[i] = input[i];
            }
            temp[0] = 1;
            input = temp;
        }
        return input;
    }
}
