package com.weiqian.leetcodesolutions.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * 46. Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class A46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        // Step1: corner case
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        constructPermutation(res, nums, new ArrayList<>());
        return res;
    }



    public void constructPermutation(List<List<Integer>> res, int[] nums, ArrayList<Integer> list){
        // Step3: when to stop
        // when list.size == nums.length, it means a new permutation is created and ready to be put into the res list
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        // Step2: the permutation starts with every element in the original array
        for(int i  = 0; i < nums.length; i++){
            // 2-3. if the current number is already used, go to the next number
            if(list.contains(nums[i])) continue;

            // 2-1. add current int into the current list
            list.add(nums[i]);
            // 2-2. continue construct the remaining part
            // --> since we pass nums into the next level, how to deal with meeting the current number repeatly? --> 2-3
            // then will meet Step3.
            constructPermutation(res, nums, list);

            // 2-4. each step, remove the previous one
            // e.g. after [1,2,3] --> go back to [1,2] --> go back to [1] --> [1,3]
            list.remove(list.size()-1);
        }
    }
}
