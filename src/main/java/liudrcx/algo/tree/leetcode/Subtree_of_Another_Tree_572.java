package liudrcx.algo.tree.leetcode;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class Subtree_of_Another_Tree_572 {

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null) {
        return false;
      }

      return isSameTreeWithRoot(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTreeWithRoot(TreeNode root, TreeNode subRoot) {
      if (root == null && subRoot == null) {
        return true;
      }

      if (root == null || subRoot == null) {
        return false;
      }

      if (root.val != subRoot.val) {
        return false;
      }

      return isSameTreeWithRoot(root.left, subRoot.left) && isSameTreeWithRoot(root.right, subRoot.right);
    }
  }
}
