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

        int[] extractTestValues = new int[]{55,39,41,18,27,12,33};
        MaxBinaryHeap binaryHeap2 = new MaxBinaryHeap();
        for(int i = 0; i < extractTestValues.length; i++){
            binaryHeap2.values.add(extractTestValues[i]);
        }
        System.out.println("binaryHeap2.extractMax() 1");
        System.out.println(binaryHeap2.extractMax());
        System.out.println(Arrays.toString(binaryHeap2.values.toArray()));
        System.out.println("binaryHeap2.extractMax() 2");
        System.out.println(binaryHeap2.extractMax());
        System.out.println(Arrays.toString(binaryHeap2.values.toArray()));
    }

    public int extractMax(){
        int extractValue = values.remove(0);
        int last = values.remove(values.size()-1);
        values.add(0,last);
        if(values.size() == 1){
            return extractValue;
        }
        // we do this to make sure you get to compare
        // everything as you go down the tree
        extractMaxHelper(0);
        return extractValue;
    }

    public void extractMaxHelper(int cur){
        int curIndex = cur;
        int curLeftIndex = getChildL(curIndex);
        int curRightIndex = getChildR(curIndex);
        if(curRightIndex > values.size()-1 || curLeftIndex > values.size()-1){
            return;
        }
        int curValu = values.get(curIndex);
        int curLeft = values.get(curLeftIndex);
        int curRight = values.get(curRightIndex);
        if(curLeft > curRight && curLeft > curValu){
            swap(curLeftIndex,curIndex,values);
            extractMaxHelper(curLeftIndex);
        }else if(curRight > curLeft && curRight > curValu){
            swap(curRightIndex,curIndex,values);
            extractMaxHelper(curRightIndex);
        }

    }

    public void Insert(int value){
        values.add(value);
        int curIndex = values.size() - 1;
        if(curIndex == 0) return;
        int parentIndex = getParent(curIndex);
        int parentValue = values.get(parentIndex);
        int initialValue = values.get(0);
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

    public static int getChildL(int curIndex){
        return 2*curIndex + 1;
    }

    public static int getChildR(int curIndex){
        return 2*curIndex + 2;
    }

}
