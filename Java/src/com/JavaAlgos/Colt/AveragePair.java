package com.JavaAlgos.Colt;

public class AveragePair {
    /*
    * Write a function called average pair. Given a sorted array of integers and a target average,
    * determine if there is a pair of values in the array where the average of the pair equals the
    * target average. There may be more than one pair that matched the average target
    * */

    public static void main(String[] args){
        System.out.println(finPair(new double[]{1,2,3},2.5));
        System.out.println(finPair(new double[]{1,3,3,5,6,7,10,12,19},8));
        System.out.println(finPair(new double[]{-1,0,3,4,5,6},4.1));
        System.out.println(finPair(new double[]{},4));
    }

    public static boolean finPair(double[] array,double target){
        if(array.length == 0) return false;
        int p1 = 0;
        int p2 = array.length-1;
        while(p1 < p2){
            double p1Value = array[p1];
            double p2Value = array[p2];
            double curAvg = computeAverage(p1Value,p2Value);
            if(curAvg == target) return true;
            if(curAvg < target){
                p1++;
            }else{
                p2--;
            }
        }
        return false;
    }

    public static double computeAverage(double a, double b){
        return (a+b)/2;
    }
}
