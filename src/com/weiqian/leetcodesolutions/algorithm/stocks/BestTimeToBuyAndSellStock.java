package com.weiqian.leetcodesolutions.algorithm.stocks;

/*
 * Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 */
public class BestTimeToBuyAndSellStock {

    /*
     * Case 1: At most one transaction
     *
     * Example1:
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     *
     * Example 2:
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     */
    public int AtMostOneTransaction(int[] prices) {
        // minValue: to track if it's the lowest value to buy
        // profit: a global value to track the profit, if at any point the local profit is greater than the glabal profit, then set the gloabal profit as this local value.

        if(prices == null || prices.length < 2) return 0;

        int minValue = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            minValue = Math.min(minValue, prices[i]);
            profit = Math.max(profit, prices[i] - minValue);
        }

        return profit;
    }



    /*
     * Case 2: Exactly one transaction
     */
    public int ExactlyOneTransaction(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int minValue = prices[0];
        int profit = prices[1] - prices[0];

        for(int i = 1; i < prices.length; i++){
            minValue = Math.min(minValue, prices[i-1]); //和前一种情况的区别其实在于[i-1]
            profit = Math.max(profit, prices[i] - minValue);
        }
        return profit;
    }



    /*
     * Case 3: Exactly k transaction
     */
    public int ExactlyKTransaction(int[] prices) {
        return 0;
    }


    /*
     * Case 4: As many transactions as you like
     */
    public int AsManyTransactionsYouLike(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int allMax = prices[0];
        int allMin = prices[0];

        for(int i = 1; i < prices.length-1; i++){
            if(prices[i] > prices[i-1] && prices[i] > prices[i+1]){
                allMax += prices[i];
            }
            if(prices[i] < prices[i-1] && prices[i] < prices[i+1]){
                allMin += prices[i];
            }
        }
        return allMax - allMin;
    }


    /*
     * Case 5: At most two transactions
     */
    public int AtMostTwoTransactions(int[] prices) {
        return 0;
    }


    /*
     * Case 6: At most k transactions
     */
    public int AtMostKTransactions(int[] prices) {
        /*
         * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
         * For k transactions, on i-th day
         *
         *
         */

        return 0;
    }

    /*
     * Case 7: Cool Down
     */
    public int WithCoolDown(int[] prices){
        //dp[i] = max(dp[i-1], prices[i] - prices[j] + dp[j-2]), j=[0..i-1]


        return 0;
    }
}
