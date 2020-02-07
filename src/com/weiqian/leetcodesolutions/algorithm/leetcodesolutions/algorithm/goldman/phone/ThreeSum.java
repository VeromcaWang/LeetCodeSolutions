package com.weiqian.leetcodesolutions.algorithm.leetcodesolutions.algorithm.goldman.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {


    // 题目中的unique需要去重
    // 所有比较排序的时间复杂度都是n平方
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        // Step 1: corner case
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){ // i < nums.length-2 是为了给另外两个数留出空间
            // 去重
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1; // 注意是从i+1
            int right = nums.length - 1; // 注意是从length-1

            while(left < right){
                //满足条件的话，就加入RES，然后移动两个指针到下一个应该去的位置
                int total = nums[i] + nums[left] + nums[right];
                if(total == target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //去重
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    //移动指针到下一个位置
                    left++;
                    right--;

                    // total不满足条件的话，根据情况决定移动哪一边的指针
                } else if(total > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
