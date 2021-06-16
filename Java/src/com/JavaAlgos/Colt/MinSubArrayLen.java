package com.JavaAlgos.Colt;

import java.util.Arrays;
//209. Minimum Size Subarray Sum - Medium
public class MinSubArrayLen {
    public static void main(String[] args){
        System.out.println(find(new int[] {2,3,1,2,4,3},7));
        System.out.println(find(new int[] {2,1,6,5,4},9));
        System.out.println(find(new int[] {3,1,7,11,2,9,8,21,62,33,19},52));
        System.out.println(find(new int[] {1,4,16,22,5,7,8,9,10},39));
        System.out.println(find(new int[] {1,4,16,22,5,7,8,9,10},55));
        System.out.println(find(new int[] {4,3,3,8,1,2,3},11));
        System.out.println(find(new int[] {1,4,16,22,5,7,8,9,10},95));
        System.out.println(find2(new int[] {2,3,1,2,4,3},7));
        System.out.println(find2(new int[] {2,1,6,5,4},9));
        System.out.println(find2(new int[] {3,1,7,11,2,9,8,21,62,33,19},52));
        System.out.println(find2(new int[] {1,4,16,22,5,7,8,9,10},39));
        System.out.println(find2(new int[] {1,4,16,22,5,7,8,9,10},55));
        System.out.println(find2(new int[] {4,3,3,8,1,2,3},11));
        System.out.println(find2(new int[] {1,4,16,22,5,7,8,9,10},95));
    }
    /*
    * Return the min length of a contiguous subarray of which the sum
    * is greater than or equal to the integer passed to the function.
    *
    * If there isn't one then return zero
    * */
    public static int find(int[] arrayIn,int target){
        if(arrayIn.length == 0) return 0;
        if(arrayIn.length == 1){
            if(target == arrayIn[0] || target == arrayIn[1]){
                return 1;
            }
            if(target == arrayIn[1] + arrayIn[0]){
                return 2;
            }
        }
        int p1 = 0;
        int p2 = 1;
        int currentSum = arrayIn[0] + arrayIn[1];
        int curSize = 2;
        int minSize = Integer.MAX_VALUE;
        while(curSize > 0){
            if(currentSum >= target){
                if(currentSum >= target){
                    if(curSize < minSize){
                        minSize = curSize;
                    }
                }

                currentSum = currentSum - arrayIn[p1];
                p1++;
                curSize--;
                if(p1 == arrayIn.length-1){
                    if(arrayIn[p1] >= target){
                        minSize = 1;
                    }
                }

            }
            else {
                p2++;
                curSize++;
                if(p2 == arrayIn.length) break;
                currentSum = currentSum + arrayIn[p2];

            }

        }
        if(minSize == Integer.MAX_VALUE) return 0;
        return minSize;
    }

    // An other solution to this
    public static int find2(int[] arrayIn,int target){
        int total  = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;

        while(start < arrayIn.length){
            if(total < target && end < arrayIn.length){
                total = total + arrayIn[end];
                end++;
            }else if(total >= target){
                minLen = Math.min(minLen,end-start);
                total = total - arrayIn[start];
                start++;
            }else{
                break;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /*
    * I got to the right Idea but failed to properly implement it
    *
    * The key take about for me is that I really need to carefully debug stuff
    * in my head.
    *
    * The If conditions above is what I was getting to, however I confused by self
    * due to not keeping proper track of the sum while I was debugging
    * */
}
