package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 */
public class Sum_of_Left_Leaves_404 {

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
    public int sumOfLeftLeaves(TreeNode root) {
      if (root == null) {
        return 0;
      }

      if (isLeaf(root.left)) {
        return root.left.val + sumOfLeftLeaves(root.right);
      }

      return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode root) {
      if (root == null) {
        return false;
      }
      return root.left == null && root.right == null;
    }
  }
}
