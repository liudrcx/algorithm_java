package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class Diameter_of_Binary_Tree_543 {
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

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      depth(root);
      return max;
    }

    private int depth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int ld = depth(root.left);
      int rd = depth(root.right);
      max = Integer.max(max, ld + rd);
      return Integer.max(ld, rd) + 1;
    }
  }
}
