package com.JavaAlgos.Stephen;

import java.util.*;

public class StackAva {

    public static void main(String[] args){
        StackAva sss = new StackAva();
        sss.push(1);
        sss.push(2);
        System.out.println(sss.pop());
        System.out.println(sss.pop());
    }
    private int pointerToEnd;
    // LinkedList is a doubly linked list
    private int[] internalStack;

    public StackAva(){
        internalStack = new int[10];
        // first time you add it needs to be zero
        pointerToEnd = -1;
    }

    public void push(int input){
        if(pointerToEnd == (internalStack.length-1)){
            internalStack = Arrays.copyOf(internalStack, internalStack.length*2);
        }
        pointerToEnd++;
        internalStack[pointerToEnd] = input;

    }

    public int pop(){
        if(pointerToEnd < 0){
            return 0;
        }
        int currentEnd = internalStack[pointerToEnd];
        pointerToEnd--;
        return currentEnd;
    }

    public int peek(){
        if(pointerToEnd < 0){
            return 0;
        }
        return internalStack[pointerToEnd];
    }
}
