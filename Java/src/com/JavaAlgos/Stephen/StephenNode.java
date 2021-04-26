package com.JavaAlgos.Stephen;

public class StephenNode {
    public StephenNode nextNode;
    public int data;

    public StephenNode(int dataIn, StephenNode nextNodeIn) {
        data = dataIn;
        nextNode = nextNodeIn;
    }

    public StephenNode(int dataIn) {
        // if both are named data it does not work
        data = dataIn;
        nextNode = null;
    }
}
