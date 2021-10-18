package com.JavaAlgos.LeetCode.Top100;

public class BestTimetoBuyandSellStockII {
    /**
     *
     * MEDIUM !!!
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     *
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
     *
     * Find and return the maximum profit you can achieve.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     * Example 2:
     *
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     * Example 3:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     *
     * What I am thinking :
     * This is a type of two pointer problem
     * **/
    public static void main(String[] args){

    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int p1 = 0;
        int p2 = 1;

        for(int i = 0; i < prices.length; i++){
            if(p2 > prices.length -1) break;
            int val1 = prices[p1];
            int val2 = prices[p2];

            if((val2-val1) >= 1){
                profit = profit + (val2 - val1);

            }

            if(profit > maxProfit){
                maxProfit = profit;
            }

            p1++;
            p2++;

        }
        return maxProfit;
    }

}
