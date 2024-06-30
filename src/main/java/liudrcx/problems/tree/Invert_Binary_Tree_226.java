package liudrcx.problems.tree;

import liudrcx.algo.tree.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Invert_Binary_Tree_226 {

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
  class Solution1 {
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }

      TreeNode t = root.left;
      root.left = root.right;
      root.right = t;

      invertTree(root.left);
      invertTree(root.right);
      return root;
    }
  }

  class Solution2 {
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }

      TreeNode left = invertTree(root.left);
      TreeNode right = invertTree(root.right);
      root.left = right;
      root.right = left;

      return root;
    }
  }
}
