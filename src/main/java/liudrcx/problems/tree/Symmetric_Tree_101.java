package liudrcx.problems.tree;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Symmetric_Tree_101 {
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
    public boolean isSymmetric(TreeNode root) {
      return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
        return true;
      }

      if (left == null || right == null) {
        return false;
      }

      if (left.val != right.val) {
        return false;
      }

      return check(left.left, right.right) && check(left.right, right.left);
    }
  }
}
