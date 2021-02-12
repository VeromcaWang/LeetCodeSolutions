package com.weiqian.leetcodesolutions.algorithm.binarytree;

import apple.laf.JRSUIUtils;
import javafx.util.Pair;

import java.util.LinkedList;

/*
 * 111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *   /  \
 *  15   7
 *
 *  return its minimum depth = 2.
 *
 */
public class MinimumDepthofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /*
     * Recursion
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null && root.right != null) return minDepth(root.right)+1;
        if(root.left != null && root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }



    /*
     * DFS
     */
    public int minDepthDFS(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int res = 0;
        dfs(root, res, 1);

        return res;
    }

    public void dfs(TreeNode root, int res, int currentLevel){
        if(root.left == null && root.right == null){
            res = Math.max(res, currentLevel);
            return;
        }

        if(root.left != null){
            dfs(root.left, res, currentLevel+1);
        }

        if(root.right != null){
            dfs(root.right, res, currentLevel+1);
        }
    }


    /*
     * BFS
     */
    public int minDepthBFS(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> list = new LinkedList<>();

        if (root == null) return 0;

        list.add(new Pair(root, 1));

        int currentDepth = 0;
        while (!list.isEmpty()) {
            Pair<TreeNode, Integer> current = list.poll();
            root = current.getKey();
            currentDepth = current.getValue();

            if ((root.left == null) && (root.right == null)) break;

            if (root.left != null) {
                list.add(new Pair(root.left, currentDepth + 1));
            }
            if (root.right != null) {
                list.add(new Pair(root.right, currentDepth + 1));
            }
        }

        return currentDepth;
    }

}
