package com.JavaAlgos.Colt;

public class countUniqueValues {
    public static void main(String[] args){
        System.out.println(countUniqueValues(new int[] {1,2,3,4,4,4,7,7,12,12,13}));
        System.out.println(countUniqueValues(new int[] {1,1,1,1,1,1,2}));
        System.out.println(countUniqueValues(new int[] {-2,-1,-1,0,1}));
        System.out.println(countUniqueValues(new int[] {1,1,1,1,1,1}));
        System.out.println("-------------------------------");
        System.out.println(countUniqueValues2(new int[] {1,2,3,4,4,4,7,7,12,12,13}));
        System.out.println(countUniqueValues2(new int[] {1,1,1,1,1,1,2}));
        System.out.println(countUniqueValues2(new int[] {-2,-1,-1,0,1}));
        System.out.println(countUniqueValues2(new int[] {1,1,1,1,1,1}));
    }

    public static int countUniqueValues2(int[] arrayIn){
        if(arrayIn.length == 0) return 0;
        if(arrayIn.length == 1 && arrayIn[0] != arrayIn[1])return 2;
        int p1 = 0;
        int p2 = 1;
        while(p1 <= arrayIn.length-1 && p2 <= arrayIn.length-1){
            if(arrayIn[p1] != arrayIn[p2]){
                p1++;
                arrayIn[p1]= arrayIn[p2];
            }
            p2++;
        }
        return p1+1;
    }

    public static int countUniqueValues(int[] arrayIn){
        if(arrayIn.length == 0) return 0;
        if(arrayIn.length == 1 && arrayIn[0] != arrayIn[1])return 2;
        int p1 = 0;
        int p2 = 1;
        int count = 0;
        while(p1 <= arrayIn.length-1 && p2 <= arrayIn.length-1){
            if(arrayIn[p1] != arrayIn[p2]){
                count++;

            }
            p1++;
            p2++;
        }
        return count+1;
    }
}
