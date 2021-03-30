package com.JavaAlgos.Stephen;

import java.util.*;

public class ArrayChunk {
    public static void main(String[] args){
        System.out.println(chunkArrays(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }}, 2));
        System.out.println(chunkArrays(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }}, 2));
        System.out.println(chunkArrays(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
        }}, 3));
        System.out.println(chunkArrays(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }}, 4));
        System.out.println(chunkArrays(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }}, 10));
    }

    public static ArrayList<ArrayList<Integer>> chunkArrays(ArrayList<Integer> array, int chunkSize){
        if(array == null || chunkSize == 0 || chunkSize > array.size()){
            return new ArrayList<ArrayList<Integer>>(){{
                add(array);
            }};
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        int counter = 1;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (array.size() > 0){
            Integer currentInt = array.remove(0);
            if(counter % chunkSize == 0){
                temp.add(currentInt);
                answer.add(temp);
                temp = new ArrayList<Integer>();
            }else{
                temp.add(currentInt);
            }
            counter++;
        }

        if(temp.size() > 0){
            answer.add(temp);
        }

        return answer;
    }
}
