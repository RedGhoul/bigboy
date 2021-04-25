package com.JavaAlgos.Stephen;

public class StephenNode {
    public StephenNode nextNode;
    public int data;

    public StephenNode(int data, StephenNode nextNode) {
        data = data;
        nextNode = nextNode;
    }

    public StephenNode(int data) {
        data = data;
        nextNode = null;
    }
}
