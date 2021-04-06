package com.JavaAlgos.Stephen;

import java.util.Queue;
import java.util.Stack;

public class QueueMadeOfStacks {

    public static void main(String[] args){
        QueueMadeOfStacks ssss = new QueueMadeOfStacks();
        ssss.add(1);
        ssss.add(2);
        System.out.println(ssss.peek());
        System.out.println(ssss.remove());
        System.out.println(ssss.remove());

    }

    Stack<Integer> Start = new Stack<>();
    Stack<Integer> End = new Stack<>();

    public void add(int input){
        Start.add(input);
    }

    public int remove(){
        while(Start.isEmpty() == false){
            int value = Start.pop();
            End.add(value);
        }
        int valueRemoved = End.pop();

        while(End.isEmpty() == false){
            int value = End.pop();
            Start.add(value);
        }
        return valueRemoved;
    }

    public int peek(){
        while(Start.isEmpty() == false){
            int value = Start.pop();
            End.add(value);
        }
        int valueRemoved = End.peek();

        while(End.isEmpty() == false){
            int value = End.pop();
            Start.add(value);
        }
        return valueRemoved;
    }



}
