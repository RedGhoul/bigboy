package com.JavaAlgos.Colt;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args){
        System.out.println(find(new int[]{1,2,3,4,5,6},-4));
        System.out.println(findBin2(new int[]{1,2,3,4,5,6},-4));

    }

    public static int find(int[] array, int findValue){
        if(array.length == 0) return 0;
        return findBin(array,findValue,0,array.length-1);

    }
    // Time complexity is Log(N)
    // Recursive way
    public static int findBin(int[] array, int findValue, int start, int end){
        // you did it right but always remember that you need to add the two points
        // to get the mid
        int mid = (int)Math.floor((end+start)/2);
        if(findValue == array[mid]) return mid;
        if(end - start <= 0) return -1;
        // you already counted the mid, you don't need to see it again
        if(findValue > array[mid]){
            return findBin(array,findValue,mid+1,end);
        }else{
            return findBin(array,findValue,start,mid-1);
        }
    }

    // Iterative way
    public static int findBin2(int[] array, int findValue){
        int start = 0;
        int end = array.length-1;

        while(start <= end){
            int mid = (int)Math.floor((start+end)/2);
            int currentValue = array[mid];
            if(currentValue == findValue) return mid;
            if(currentValue > findValue){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
