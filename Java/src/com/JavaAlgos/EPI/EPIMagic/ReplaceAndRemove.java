package com.JavaAlgos.EPI.EPIMagic;

public class ReplaceAndRemove {
    /**
     * What did I learn from this ?
     * <p>
     * If your doing array operations in place, you will need to shift over / grow you array
     * which will lead to O(n^2) time complexity, OR if you copy it into a new array, you will
     * need to have a space complexity of O(n)
     * <p>
     * But you can use a multi pass system to does work pass by pass
     * then have a sort of sliding window
     **/
    public static void main(String[] args) {

        System.out.println(removeAndReplace(new char[]{'a', 'c', 'd', 'b', 'b', 'c', 'a'}, 7));
    }

    public static int removeAndReplace(char[] input, int size) {
        int writeIndex = 0;
        int aCount = 0;
        for (int i = 0; i < size; i++) {
            if (input[i] != 'b') {
                input[writeIndex++] = input[i];
            }
            if (input[i] == 'a') {
                aCount++;
            }
        }
        int curIdx = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        int finalSize = writeIndex + 1;

        while (curIdx >= 0) {
            if (input[curIdx] == 'a') {
                input[writeIndex--] = 'd';
                input[writeIndex--] = 'd';
            } else {
                input[writeIndex--] = input[curIdx];
            }
            curIdx--;
        }
        return finalSize;
    }
}
