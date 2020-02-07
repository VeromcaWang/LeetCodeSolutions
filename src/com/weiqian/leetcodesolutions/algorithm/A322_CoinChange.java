package com.weiqian.leetcodesolutions.algorithm;


/*
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */

public class A322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        // f[i] means: the minimum coins to use to get amount i.
        // If we have already chosen 1 coin: when 1 coin is fixed, the problem becomes f[i-fixed_coin_amount] + 1.
        // f[i] = f[i-fixed_coin_amount] + 1;

        //1. 确定状态，开一个数组.设定初始值
        int[] res = new int[amount+1];
        res[0] = 0;

        //f[1], f[2], ..., f[amount]
        for(int i = 1; i < res.length; i++){
            res[i] = Integer.MAX_VALUE;

            //f[i] = Min{f[i-coins[1]]+1, f[i-coins[2]]+1, ..., f[i-coins[j]]+1}
            // last coin: coins[j]
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && res[i-coins[j]] != Integer.MAX_VALUE){
                    res[i] = Math.min(res[i-coins[j]]+1, res[i]);
                }
            }
        }

        return res[amount] == Integer.MAX_VALUE? -1:res[amount];
    }
}
