package com.weiqian.leetcodesolutions.algorithm;

public class A53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        //f[i] = Max(nums[i], nums[i] + f[i-1])
        //each slot has 2 choices: add the number to the alreading existing sum / start a new one

        if(nums == null || nums.length < 1) return 0;

        int[] f = new int[nums.length];
        f[0] = nums[0];
        int res = f[0];

        for(int i = 1; i < nums.length; i++){
            f[i] = Math.max(nums[i], nums[i] + f[i-1]);
            res = Math.max(res, f[i]);
        }

        return res;
    }
}
