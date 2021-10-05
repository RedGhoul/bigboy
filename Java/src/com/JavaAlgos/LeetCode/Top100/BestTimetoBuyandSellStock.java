package com.JavaAlgos.LeetCode.Top100;

public class BestTimetoBuyandSellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a
     * different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction.
     * If you cannot achieve any profit, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * Example 2:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     *
     * Constraints:
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     * **/
    public static void main(String[] args){
//        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
//        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
//        System.out.println(maxProfit(new int[]{7,1,3,0,3,4,6,6,78}));
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }

//    public static int maxProfit(int[] prices) {
//        if(prices.length <= 1) return 0;
//        int Min = Integer.MAX_VALUE;
//        int iMin = 0;
//        for(int i =0; i < prices.length-1; i++){
//            if(prices[i] <= Min){
//                Min = prices[i];
//                iMin = i;
//            }
//        }
//
//        int Max = Integer.MIN_VALUE;
//        int iMax = 0;
//        for(int i = iMin+1; i < prices.length; i++){
//            if(prices[i] > Max && prices[i] > Min){
//                Max = prices[i];
//                iMax = i;
//            }
//        }
//        if(Max == Integer.MIN_VALUE) return 0;
//        return prices[iMax] - prices[iMin];
//
//    }

    // don't look at stuff with your eyes and make unconsous judgements
    // about how the program would go through the problem
    // pretend you are the dumb dumb computer

    // things to look more into - kanadaes algo
    // time: 0(n), space:0(1)

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int max = 0;
        int min = prices[0];
        for(int i =1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                max = Math.max(max, prices[i]-min);
            }
        }
        return max;
    }

}
