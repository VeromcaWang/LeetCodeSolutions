package com.weiqian.leetcodesolutions.algorithm;

import java.util.ArrayList;
import java.util.List;


public class A78_SubSets { //参考 46 Permutations

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        helper(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int index){
        res.add(new ArrayList<>(list));

        // index的作用： 这里循环不是从0到nums.length，因为不是permutation(每个List长度固定)
        // 这里每个List长度从0到nums.length都有，所以用Index来控制长度
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, nums, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
