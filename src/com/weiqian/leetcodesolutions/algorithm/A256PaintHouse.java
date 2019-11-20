package com.weiqian.leetcodesolutions.algorithm;

public class A256PaintHouse {
    public static int minCost(int[][] costs) {
        if(costs.length < 1) return 0;

        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i = 1; i < costs.length; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        return Math.min(dp[costs.length-1][0], Math.min(dp[costs.length-1][1], dp[costs.length-1][2]));
    }

    public static void main(String[] args){
        //System.out.println(minCost(new int[][]{{20,18,4},{9,9,10}}));
        System.out.println(minCost(new int[][]{{5,8,6},{9,14,13},{7,5,12},{14,15,17},{3,20,10}}));
    }
}
