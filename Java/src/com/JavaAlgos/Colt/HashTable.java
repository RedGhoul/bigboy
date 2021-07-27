package com.JavaAlgos.Colt;
import java.util.*;

public class HashTable {
    private ArrayList<ArrayList<HashPair>> array;
    public HashTable(int initSize){
        array = new ArrayList<ArrayList<HashPair>>();
        for (int i = 0; i < 100; i++){
            array.add(new ArrayList<HashPair>());
        }
    }
    private int HashFunc(String key,int arrLen){
        int total = 0;
        int WERID_PRIME = 31;
        for (char val : key.toCharArray()) {
            int value = (int)val - 96;
            total = (total * WERID_PRIME + value) % arrLen;
        }
        return total;
    }

    public void set(String key, String value){
        int index = HashFunc(key,100);

        ArrayList<HashPair> hpArray = this.array.get(index);

        hpArray.add(new HashPair(key,value));

    }

    public HashPair get(String key) {
        if(key == null) return null;
        int index = HashFunc(key,100);
        ArrayList<HashPair> hpArray = this.array.get(index);
        if(hpArray.stream().anyMatch(c -> c.key == key)){
            int indexV = find(key,hpArray);
            if(indexV != 0){
                return  hpArray.get(indexV);
            }
        }
        return null;
    }

    private int find(String key, ArrayList<HashPair> hpArray){
        for(int i = 0; i < hpArray.size(); i++){
            if(hpArray.get(i).key == key){
                return i;
            }
        }
        return 0;
    }
    // get values or keys method results in a double for loop
}
