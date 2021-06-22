package com.JavaAlgos.Colt;

import java.util.ArrayList;

public class productOfArray {
    public static void main(String[] args){
        var sss = new ArrayList<Integer>();
        sss.add(2);
        sss.add(3);
        sss.add(4);
        sss.add(5);
        sss.add(6);
        System.out.println(findProduct(sss));
    }

    public static int findProduct(ArrayList<Integer> list){
       if(list == null || list.size() == 0) {
           return 0;
       }

       int product = list.remove(0);
       int other =  findProduct(list);
       if(other == 0){
           other = 1;
       }
       product = product * other;
       return product;

    }
}
