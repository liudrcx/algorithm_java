package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 *https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class Balanced_Binary_Tree_110 {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
  class Solution {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
      height(root);
      return isBalanced;
    }

    private int height(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int l = height(root.left);
      int r = height(root.right);
      if (Math.abs(l - r) > 1) {
        isBalanced = false;
      }
      return 1 + Integer.max(l, r);
    }
  }
}
