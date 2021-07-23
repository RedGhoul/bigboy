package com.JavaAlgos.Colt;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxBinaryHeap {
    public ArrayList<Integer> values = new ArrayList<>();

    public static void main(String[] args){
        int[] ss = new int[]{41,39,33,18,27,12};
        MaxBinaryHeap sss = new MaxBinaryHeap();
        for(int i = 0; i < ss.length; i++){
            sss.values.add(ss[i]);
        }
        sss.Insert(55);
        System.out.println(Arrays.toString(sss.values.toArray()));
    }

    public void Insert(int value){
        values.add(value);
        int curIndex = values.size() - 1;
        if(curIndex == 0) return;
        int parentIndex = getParent(curIndex);
        int parentValue = values.get(parentIndex);
        int initialValue = values.get(curIndex);
        while(initialValue > parentValue){
            swap(curIndex, parentIndex,values);
            curIndex = parentIndex;
            parentIndex = getParent(curIndex);
            parentValue = values.get(parentIndex);
            initialValue = values.get(curIndex);
        }
        return;
    }

    public void bubble(int initialIndex){
        int parentIndex = getParent(initialIndex);
        int parentValue = values.get(parentIndex);
        int initialValue = values.get(initialIndex);
        if(initialValue > parentValue){
            swap(initialIndex, parentValue,values);
            initialIndex = parentIndex;
            bubble(initialIndex);
        }
        return;
    }

    public void swap(int a, int b, ArrayList<Integer> arr){
        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
    }

    public static int getParent(int curIndex){
        if (curIndex == 0) return 0;
        return (int) Math.floor((curIndex-1)/2);
    }

}
