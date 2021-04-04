package com.JavaAlgos.Stephen;

public class QueueAva {
    private int[] dataStore;
    private int count = 0;
    private int front = 0;
    public QueueAva(){
        dataStore = new int[10];
    }

    public static void main(String[] args){
        QueueAva ttt = new QueueAva();
        for(int i =0; i < 100; i++){
            ttt.add(i);
        }
        ttt.remove();
        ttt.add(2033333);
        System.out.println(ttt.remove());
        System.out.println(ttt.remove());
    }

    public void add(int i){
        if(dataStore.length == count){
            dataStore = arrayCopy(dataStore);
        }
        dataStore[count] = i;
        count++;
    }

    public int remove(){
        if(count < 0 || front == count){
            return 0;
        }
        int itemToReturn = dataStore[front];
        dataStore[front] =0;
        front++;
        return itemToReturn;
    }

    public int peek(){
        if(count < 0 || front == count){
            return 0;
        }
        int itemToReturn = dataStore[front];
        return itemToReturn;
    }

    private int[] arrayCopy(int[] current){
        int[] newArr = new int[current.length*2];
        for(int i =0; i < current.length; i++){
            newArr[i] = current[i];
        }
        return newArr;
    }


}
