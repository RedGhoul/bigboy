package com.JavaAlgos.Colt;

import java.util.ArrayList;

public class CollectOdd {
    public static void main(String[] args){
        var sss = new ArrayList<Integer>();
        sss.add(2);
        sss.add(3);
        sss.add(4);
        sss.add(5);
        sss.add(6);
        var ss2 = new ArrayList<>(sss);
        System.out.println(collectOdd(sss));
        System.out.println(collectOddPure(ss2));

    }

    public static ArrayList<Integer> collectOdd(ArrayList<Integer> input){
        if(input == null || input.size() == 0){
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();

        collectOddHelper(input, result);
        return result;
    }

    public static ArrayList<Integer> collectOddHelper(ArrayList<Integer> input, ArrayList<Integer> result){
        if(input.size() == 0){
            return null;
        }
        int curr = input.remove(0);

        if(curr % 2 != 0){
            result.add(curr);
        }
        return collectOddHelper(input,result);
    }


    public static ArrayList<Integer> collectOddPure(ArrayList<Integer> input){
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.size() == 0){
            return result;
        }

        int curr = input.remove(0);

        if(curr % 2 != 0){
            result.add(curr);
        }

        result.addAll(collectOddPure(input));
        return result;
    }
}
