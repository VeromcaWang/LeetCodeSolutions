package com.weiqian.leetcodesolutions.algorithm.leetcodesolutions.algorithm.goldman.phone;

public class TrappingRainWater {

    // dp
    public int trap1(int[] height) {
        if(height == null || height.length == 0) return 0;

        int res = 0;

        // 重点在于用两个数组记录在每个SLOT处能够reach到的左侧右侧最高的值
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        for(int i = height.length-2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        for(int i = 1; i < height.length; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    // 2 pointers
    public int trap2(int[] height){

        if(height == null || height.length == 0) return 0;

        int res = 0;

        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
