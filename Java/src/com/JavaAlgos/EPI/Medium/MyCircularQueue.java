package com.JavaAlgos.EPI.Medium;

class MyCircularQueue {
    private Integer[] internal;
    private int p1 = 0;
    private int p2 = 0;
    private int count = 0;

    public MyCircularQueue(int k) {
        internal = new Integer[k];
    }

    public boolean enQueue(int value) {
        if (p2 == 0 && p1 == 0 && internal[p1] == null) {
            internal[p2] = value;
            count++;
            return true;
        }
        p2++;
        if (p2 > internal.length - 1) {
            p2--;
            return false;
        }
        if (internal[p2] == null) {
            internal[p2] = value;
            count++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (count == 0) return false;
        int val = internal[p1];
        internal[p1] = null;
        for (int i = 0; i < internal.length - 1; i++) {
            internal[i] = internal[i + 1];
        }
        internal[p2] = null;
        p2--;
        count--;
        return true;
    }

    public int Front() {
        if (internal[p1] == null) return -1;
        return internal[p1];
    }

    public int Rear() {
        if (internal[p2] == null) return -1;
        return internal[p2];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == internal.length;
    }
}