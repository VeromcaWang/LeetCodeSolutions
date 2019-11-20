package com.weiqian.leetcodesolutions.algorithm;

public class A746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int steps = cost.length;
        int[] f = new int[steps+1];

        f[0] = 0;
        f[1] = 0;

        for(int i = 2; i < steps+1; i++){
            f[i] = Math.min((f[i-1]+cost[i-1]),(f[i-2]+cost[i-2]));
        }

        return f[steps];
    }
}
