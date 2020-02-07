package com.weiqian.leetcodesolutions.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level)
 *
 * Example 1:
 * Given binary tree [3,9,20,null,null,15,7]
 *         3
 *       /  \
 *      9   20
 *         /  \
 *        15  7
 *
 * return its level order traversal as:
 *      [
 *       [3],
 *       [9,20],
 *       [15,7]
 *      ]
 */
public class A102_BinaryTreeLevelOrderTraverse {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /*
     * Approach 1: DFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }

    public void traverse(TreeNode root, List<List<Integer>> list, int h){
        if(root == null) return;
        if(h == list.size()){
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            list.add(l);
        } else {
            List<Integer> l = list.get(h);
            l.add(root.val);
        }
        traverse(root.left, list, h+1);
        traverse(root.right, list, h+1);
    }


    /*
     * Approach 2: BFS
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < length; i++){
                TreeNode n = queue.remove();
                list.add(n.val);
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
            res.add(list);
        }
        return res;
    }


}
