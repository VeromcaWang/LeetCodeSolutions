package com.weiqian.leetcodesolutions.algorithm.stocks;

public class Run {

    public static void main(String[] args){
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(stock.ExactlyOneTransaction(prices));
    }
}
